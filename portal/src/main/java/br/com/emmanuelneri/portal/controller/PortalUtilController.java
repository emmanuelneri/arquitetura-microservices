package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.TokenUsuarioUtil;
import br.com.emmanuelneri.portal.util.annotations.ConfiguracaoAplicacao;
import br.com.emmanuelneri.portal.util.annotations.UsuarioLogado;
import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class PortalUtilController implements Serializable {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    @Inject
    @ConfiguracaoAplicacao
    private Configuracao configuracao;

    public void redirectAplicacao(Modulo moduloMenu) throws IOException {
        final String token = TokenUsuarioUtil.createToken(usuario, moduloMenu);
        Faces.redirect(moduloMenu.getUrl() + "?token=%s&", token);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }
}
