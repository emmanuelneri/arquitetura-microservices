package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.integrador.autenticacao.TokenUsuarioUtil;
import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.annotations.ConfiguracaoAplicacao;
import br.com.emmanuelneri.portal.util.annotations.UsuarioLogado;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UtilPortalController {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    @Inject
    @ConfiguracaoAplicacao
    private Configuracao configuracao;

    public void redirectAplicacao(Modulo moduloMenu) throws IOException {
       TokenUsuarioUtil.redirectAplicacao(usuario.toVo(), moduloMenu.toVo());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }
}
