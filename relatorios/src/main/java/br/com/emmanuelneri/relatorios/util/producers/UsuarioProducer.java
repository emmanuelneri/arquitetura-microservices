package br.com.emmanuelneri.relatorios.util.producers;

import br.com.emmanuelneri.anotations.UsuarioLogado;
import br.com.emmanuelneri.relatorios.model.Usuario;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public Usuario getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}