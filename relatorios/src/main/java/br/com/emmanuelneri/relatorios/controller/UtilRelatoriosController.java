package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.integrador.anotations.UsuarioLogado;
import br.com.emmanuelneri.integrador.autenticacao.TokenUsuarioUtil;
import br.com.emmanuelneri.integrador.vo.ModuloVO;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import br.com.emmanuelneri.relatorios.util.ApplicationProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UtilRelatoriosController {

    @Inject
    @UsuarioLogado
    private UsuarioVO usuario;

    @Inject
    private ApplicationProperty configuracao;

    public void redirectAplicacao(ModuloVO moduloMenu) throws IOException {
        TokenUsuarioUtil.redirectAplicacao(usuario, moduloMenu);
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
