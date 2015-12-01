package br.com.emmanuelneri.vendas.util.producers;

import br.com.emmanuelneri.integrador.anotations.UsuarioLogado;
import br.com.emmanuelneri.vendas.model.Usuario;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public Usuario getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}