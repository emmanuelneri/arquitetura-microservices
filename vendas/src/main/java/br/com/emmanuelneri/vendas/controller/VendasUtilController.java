package br.com.emmanuelneri.vendas.controller;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.annotations.UsuarioLogadoPortal;
import br.com.emmanuelneri.vendas.util.ApplicationProperty;
import br.com.emmanuelneri.vendas.util.Constantes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Named
@RequestScoped
public class VendasUtilController implements Serializable {

    @Inject
    @UsuarioLogadoPortal
    private Usuario usuario;

    @Inject
    private ApplicationProperty configuracao;

    public String formtValor(BigDecimal bigDecimal) {
        return getDecimalFormat().format(bigDecimal);
    }

    private DecimalFormat getDecimalFormat() {
        return new DecimalFormat("'R$' #,###,##0.00", new DecimalFormatSymbols(Constantes.PT_BR));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ApplicationProperty getConfiguracao() {
        return configuracao;
    }
}
