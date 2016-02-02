package br.com.emmanuelneri.cadastros.util.producers;


import br.com.emmanuelneri.cadastros.util.anotations.UsuarioLogadoCadastros;
import br.com.emmanuelneri.portal.model.Usuario;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Dependent
public final class UsuarioCadastrosProducer {

    @Named("usuarioLogadoCadastros")
    @Produces
    @UsuarioLogadoCadastros
    public Usuario getUsuarioCadastroLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(Usuario.class);
    }

}
