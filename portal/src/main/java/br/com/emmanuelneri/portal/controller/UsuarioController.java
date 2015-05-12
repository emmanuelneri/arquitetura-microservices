package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.service.UsuarioService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;

    @Inject
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        buscar();
    }

    private void buscar() {
        this.usuarios = this.usuarioService.findAll();
    }

    public void salvar() {
        this.usuarioService.save(usuario);
        init();
    }

    public void deletar() {
        this.usuarioService.delete(usuario);
        buscar();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
