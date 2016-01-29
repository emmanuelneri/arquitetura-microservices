package br.com.emmanuelneri.integrador.autenticacao;

import br.com.emmanuelneri.integrador.properties.AbstractApplicationProperty;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public abstract class UsuarioModuloRealm extends AuthorizingRealm {

    public UsuarioModuloRealm() {
        setAuthenticationTokenClass(UsuarioPortalToken.class);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        final UsuarioPortalToken usuarioPortalToken = (UsuarioPortalToken) authenticationToken;

        if (usuarioPortalToken.getChaveAplicacao() != null && getAplicationProperty().getChaveAplicacao().equals(usuarioPortalToken.getChaveAplicacao())) {
            return new SimpleAuthenticationInfo(usuarioPortalToken.getUsuario(), usuarioPortalToken.getUsuario().getId(), getName());
        }

        throw new UnknownAccountException("Chave inválida");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return new SimpleAuthorizationInfo(((UsuarioVO) principal.getPrimaryPrincipal()).getRoles());
    }

    protected abstract AbstractApplicationProperty getAplicationProperty();

}
