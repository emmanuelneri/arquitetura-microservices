package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.annotations.UsuarioLogado;
import br.com.emmanuelneri.relatorios.util.ApplicationProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class RelatoriosUtilController implements Serializable {

    @Inject
    @UsuarioLogado
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
