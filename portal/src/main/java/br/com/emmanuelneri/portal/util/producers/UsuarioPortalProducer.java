package br.com.emmanuelneri.portal.util.producers;


import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.annotations.UsuarioLogadoPortal;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Dependent
public final class UsuarioPortalProducer {

    @Named("usuarioLogadoPortal")
    @Produces
    @UsuarioLogadoPortal
    public Usuario getUsuarioPortalLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}
