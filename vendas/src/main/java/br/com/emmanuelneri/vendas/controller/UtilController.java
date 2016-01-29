package br.com.emmanuelneri.vendas.controller;

import br.com.emmanuelneri.integrador.anotations.UsuarioLogado;
import br.com.emmanuelneri.integrador.autenticacao.TokenUsuarioUtil;
import br.com.emmanuelneri.integrador.interfaces.Constantes;
import br.com.emmanuelneri.integrador.vo.ModuloVO;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import br.com.emmanuelneri.vendas.util.ApplicationProperty;
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
