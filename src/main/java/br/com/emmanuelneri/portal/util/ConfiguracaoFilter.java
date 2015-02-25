package br.com.emmanuelneri.portal.util;


import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.ConfiguracaoService;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfiguracaoFilter implements Filter {

    @Inject
    private ConfiguracaoService configuracaoService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final Configuracao configuracao = configuracaoService.findConfiguracao();

        final String url = ((HttpServletRequest) servletRequest).getRequestURI();

        if(configuracao == null && !url.equals("/portal/configuracao-inicial.xhtml")) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendRedirect("/portal/configuracao-inicial.xhtml");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
