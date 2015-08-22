package br.com.emmanuelneri.portal.util.producers;


import br.com.emmanuelneri.anotations.UsuarioLogado;
import br.com.emmanuelneri.portal.model.Usuario;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public final class UsuarioProducer {

    @Named("usuarioLogado")
    @Produces
    @UsuarioLogado
    public Usuario getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}
