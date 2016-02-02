package br.com.emmanuelneri.relatorios.util.producers;


import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.relatorios.util.anotations.UsuarioLogadoRelatorios;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Dependent
public final class UsuarioRelatoriosProducer {

    @Named("usuarioLogadoRelatorios")
    @Produces
    @UsuarioLogadoRelatorios
    public Usuario getUsuarioRelatoriosLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}
