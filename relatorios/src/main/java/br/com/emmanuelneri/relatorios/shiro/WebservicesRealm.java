package br.com.emmanuelneri.relatorios.shiro;

import br.com.emmanuelneri.integrador.interfaces.Constantes;
import br.com.emmanuelneri.relatorios.model.Usuario;
import br.com.emmanuelneri.relatorios.service.UsuarioService;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Arrays;

public class WebservicesRealm extends AuthorizingRealm {

    public static final String REALM_NAME = "webservicesRealm";

    public WebservicesRealm() {
        setName(REALM_NAME);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        final UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        final Usuario usuario = getUsuarioService().findByEmail(Constantes.WS_EMAIL);
        if (Constantes.WS_EMAIL.equals(token.getUsername())) {
            final SimplePrincipalCollection pc = new SimplePrincipalCollection(
                    Arrays.asList(Constantes.WS_EMAIL, usuario.getId(), usuario), getName());

            return new SimpleAuthenticationInfo(pc, Constantes.WS_SENHA);
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo(((Usuario) principals.getPrimaryPrincipal()).getRoles());
    }

    UsuarioService getUsuarioService() {
        return BeanProvider.getContextualReference(UsuarioService.class, false);
    }

}
