package br.com.emmanuelneri.cadastros.controller;

import br.com.emmanuelneri.cadastros.util.ApplicationProperty;
import br.com.emmanuelneri.cadastros.util.anotations.UsuarioLogadoCadastros;
import br.com.emmanuelneri.portal.model.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class CadastrosUtilController implements Serializable {

    @Inject
    @UsuarioLogadoCadastros
    private Usuario usuario;

    @Inject
    private ApplicationProperty configuracao;

    public Usuario getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
