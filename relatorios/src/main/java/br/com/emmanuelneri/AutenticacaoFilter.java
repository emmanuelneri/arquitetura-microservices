package br.com.emmanuelneri;

import br.com.emmanuelneri.integrador.filter.AbstractAutenticacaoFilter;

public class AutenticacaoFilter extends AbstractAutenticacaoFilter {

    @Override
    protected String getUrlHome() {
        return "/relatorios/home";
    }
}
