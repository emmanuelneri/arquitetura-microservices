package br.com.emmanuelneri.shiro;

import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.service.UsuarioService;
import br.com.emmanuelneri.portal.util.TokenUsuarioUtil;
import com.auth0.jwt.JWTVerifyException;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Map;

public class UsuarioTokenRealm extends AuthorizingRealm {

    public static final String REALM_NAME = "usuarioTokenRealm";

    public UsuarioTokenRealm() {
        setName(REALM_NAME);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        final UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        Map<String, Object> tokenMap;

        try {
            tokenMap = TokenUsuarioUtil.getTokenMap(token.getUsername());
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException | JWTVerifyException ex) {
           return null;
        }

        String chaveAplicacao = (String) tokenMap.get("chaveAplicacao");
        String email = (String) tokenMap.get("email");

        final Usuario usuario = getUsuarioService().findCompletoByEmail(email);

        if (usuario != null && Modulo.PORTAL.getChave().equals(chaveAplicacao)) {
            final SimplePrincipalCollection pc = new SimplePrincipalCollection(
                    Arrays.asList(usuario.getEmail(), usuario.getId(), usuario), getName());

            return new SimpleAuthenticationInfo(pc, token.getPassword());
        } else {
            return null;
        }
    }

    UsuarioService getUsuarioService() {
        return BeanProvider.getContextualReference(UsuarioService.class, false);
    }
}
