package br.com.emmanuelneri.relatorios.autenticacao;

import br.com.emmanuelneri.portal.util.AbstractAutenticacaoFilter;

public class AutenticacaoFilter extends AbstractAutenticacaoFilter {

    @Override
    protected String getUrlRedirect() {
        return "/relatorios/home";
    }
}
