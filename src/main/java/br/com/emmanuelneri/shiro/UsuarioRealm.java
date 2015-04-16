package br.com.emmanuelneri.shiro;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.service.UsuarioService;
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

import java.util.Arrays;

public class UsuarioRealm extends AuthorizingRealm {

    public static final String REALM_NAME = "usuarioRealm";

    public UsuarioRealm() {
        setName(REALM_NAME);
    }

    public static PrincipalCollection createPrincipalCollection(Usuario usuario) {
        return new SimplePrincipalCollection(
                Arrays.asList(usuario.getEmail(), usuario.getId(), usuario), REALM_NAME);
    }

    UsuarioService getUsuarioService() {
        return BeanProvider.getContextualReference(UsuarioService.class, false);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        final Usuario usuarioPrincipal = principals.oneByType(Usuario.class);
        if (usuarioPrincipal == null) {
            throw new AuthorizationException("Invalid credentials");
        }

        final Usuario usuario = getUsuarioService().buscaParaLogin(usuarioPrincipal.getEmail());

        if (usuario != null) {
            return new SimpleAuthorizationInfo();
        } else {
            return null;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;

        Usuario usuario = getUsuarioService()
                .buscaParaLogin(token.getUsername());
        if (usuario != null) {
            PrincipalCollection pc = createPrincipalCollection(usuario);

            return new SimpleAuthenticationInfo(pc, usuario.getSenha());
        } else {
            return null;
        }
    }

}
