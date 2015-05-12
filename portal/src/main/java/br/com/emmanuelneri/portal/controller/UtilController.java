package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.UsuarioLogado;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UtilController {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }
}
