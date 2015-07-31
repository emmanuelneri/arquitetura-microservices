package br.com.emmanuelneri.vendas.controller;

import br.com.emmanuelneri.vendas.shiro.ModuloVO;
import br.com.emmanuelneri.vendas.shiro.UsuarioVO;
import br.com.emmanuelneri.vendas.util.ApplicationProperty;
import br.com.emmanuelneri.vendas.util.Constantes;
import br.com.emmanuelneri.vendas.util.TokenUsuarioUtil;
import br.com.emmanuelneri.vendas.util.anotations.UsuarioLogado;
import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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

    public String formtValor(BigDecimal bigDecimal) {
        return getDecimalFormat().format(bigDecimal);
    }

    private DecimalFormat getDecimalFormat() {
        return new DecimalFormat("'R$' #,###,##0.00", new DecimalFormatSymbols(Constantes.PT_BR));
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
