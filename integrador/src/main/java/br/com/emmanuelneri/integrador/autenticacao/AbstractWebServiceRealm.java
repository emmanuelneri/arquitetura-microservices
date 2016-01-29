package br.com.emmanuelneri.integrador.autenticacao;

import br.com.emmanuelneri.integrador.interfaces.Constantes;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
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

public abstract class AbstractWebServiceRealm extends AuthorizingRealm {

    public static final String REALM_NAME = "webservicesRealm";

    public AbstractWebServiceRealm() {
        setName(REALM_NAME);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        final UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (Constantes.WS_EMAIL.equals(token.getUsername()) && Constantes.WS_SENHA.equals(String.valueOf(token.getPassword()))) {
            final UsuarioVO usuario = new UsuarioVO(token.getUsername());

            final SimplePrincipalCollection pc = new SimplePrincipalCollection(
                    Arrays.asList(Constantes.WS_EMAIL, usuario.getEmail(), usuario), getName());

            return new SimpleAuthenticationInfo(pc, Constantes.WS_SENHA);
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo(((UsuarioVO) principals.getPrimaryPrincipal()).getRoles());
    }
}