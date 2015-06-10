package br.com.emmanuelneri.autenticacao;

import br.com.emmanuelneri.portal.service.UsuarioService;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoFilter implements Filter {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String token = servletRequest.getParameter("token");

        if(!Strings.isNullOrEmpty(token)) {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(token, token, false, "token"));
            sendRedirect(servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void sendRedirect(ServletResponse servletResponse) throws IOException {
        final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect("/portal/home");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
