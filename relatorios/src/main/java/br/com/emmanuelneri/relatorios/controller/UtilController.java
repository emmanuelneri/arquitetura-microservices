package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.relatorios.shiro.ModuloVO;
import br.com.emmanuelneri.relatorios.shiro.UsuarioVO;
import br.com.emmanuelneri.relatorios.util.ApplicationProperty;
import br.com.emmanuelneri.relatorios.util.TokenUsuarioUtil;
import br.com.emmanuelneri.relatorios.util.anotations.UsuarioLogado;
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
    private UsuarioVO usuario;

    @Inject
    private ApplicationProperty configuracao;

    public void redirectAplicacao(ModuloVO moduloMenu) throws IOException {
        final String token = TokenUsuarioUtil.createToken(usuario, moduloMenu);
        Faces.redirect(moduloMenu.getUrl() + "?token=%s&", token);
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
