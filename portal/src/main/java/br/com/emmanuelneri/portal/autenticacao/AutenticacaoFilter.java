package br.com.emmanuelneri.portal.autenticacao;

import br.com.emmanuelneri.portal.util.AbstractAutenticacaoFilter;

public class AutenticacaoFilter extends AbstractAutenticacaoFilter {

    @Override
    protected String getUrlRedirect() {
        return "/portal/home";
    }
}
