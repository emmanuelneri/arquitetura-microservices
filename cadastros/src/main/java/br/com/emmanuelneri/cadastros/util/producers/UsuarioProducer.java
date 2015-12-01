package br.com.emmanuelneri.cadastros.util.producers;

import br.com.emmanuelneri.cadastros.model.Usuario;
import br.com.emmanuelneri.integrador.anotations.UsuarioLogado;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public Usuario getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}