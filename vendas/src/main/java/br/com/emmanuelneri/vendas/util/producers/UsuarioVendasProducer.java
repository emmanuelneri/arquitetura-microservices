package br.com.emmanuelneri.vendas.util.producers;


import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.vendas.util.anotations.UsuarioLogadoVendas;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Dependent
public final class UsuarioVendasProducer {

    @Named("usuarioLogadoVendas")
    @Produces
    @UsuarioLogadoVendas
    public Usuario getUsuarioVendasLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}
