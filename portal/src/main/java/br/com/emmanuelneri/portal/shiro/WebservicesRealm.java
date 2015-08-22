package br.com.emmanuelneri.portal.shiro;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.interfaces.Constantes;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Arrays;

public class WebservicesRealm extends UsuarioRealm {

    public static final String REALM_NAME = "webservicesRealm";

    public WebservicesRealm() {
        setName(REALM_NAME);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        final Usuario usuario = getUsuarioService().findByEmail(Constantes.WS_EMAIL);
        if (Constantes.WS_EMAIL.equals(token.getUsername())) {
            final SimplePrincipalCollection pc = new SimplePrincipalCollection(
                    Arrays.asList(Constantes.WS_EMAIL, usuario.getId(), usuario), getName());

            return new SimpleAuthenticationInfo(pc, Constantes.WS_SENHA);
        } else {
            return null;
        }
    }

}
