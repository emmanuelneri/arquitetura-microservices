package br.com.emmanuelneri.vendas.autenticacao;

import br.com.emmanuelneri.portal.util.AbstractAutenticacaoFilter;

public class AutenticacaoFilter extends AbstractAutenticacaoFilter {

    @Override
    protected String getUrlRedirect() {
        return "/pedidos/home";
    }
}