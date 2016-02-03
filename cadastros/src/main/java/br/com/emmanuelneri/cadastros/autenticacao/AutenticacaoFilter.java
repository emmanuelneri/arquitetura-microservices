package br.com.emmanuelneri.cadastros.autenticacao;

import br.com.emmanuelneri.portal.util.AbstractAutenticacaoFilter;

public class AutenticacaoFilter extends AbstractAutenticacaoFilter {

    @Override
    protected String getUrlRedirect() {
        return "/cadastros/home";
    }
}
