package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.integrador.anotations.UsuarioLogado;
import br.com.emmanuelneri.integrador.autenticacao.TokenUsuarioUtil;
import br.com.emmanuelneri.relatorios.model.Modulo;
import br.com.emmanuelneri.relatorios.model.Usuario;
import br.com.emmanuelneri.relatorios.util.ApplicationProperty;
import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UtilController {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    @Inject
    private ApplicationProperty configuracao;

    public void redirectAplicacao(Modulo moduloMenu) throws IOException {
        final String token = TokenUsuarioUtil.createToken(usuario, moduloMenu);
        Faces.redirect(moduloMenu.getUrl() + "?token=%s&", token);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
