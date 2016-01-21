package br.com.emmanuelneri.cadastros.shiro;

import br.com.emmanuelneri.cadastros.util.ApplicationProperty;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.shiro.UsuarioPortalToken;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class UsuarioRealm extends AuthorizingRealm {

    public UsuarioRealm() {
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
        return new SimpleAuthorizationInfo(((Usuario) principal.getPrimaryPrincipal()).getRoles());
    }

    ApplicationProperty getAplicationProperty() {
        return BeanProvider.getContextualReference(ApplicationProperty.class, false);
    }

}
