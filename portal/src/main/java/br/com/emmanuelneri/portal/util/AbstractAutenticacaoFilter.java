package br.com.emmanuelneri.portal.util;

import br.com.emmanuelneri.portal.service.UsuarioService;
import com.auth0.jwt.JWTVerifyException;
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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAutenticacaoFilter implements Filter {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String token = servletRequest.getParameter("token");

        if(!Strings.isNullOrEmpty(token)) {
            Map<String, Object> tokenMap = new HashMap<>();
            try {
                tokenMap = TokenUsuarioUtil.getTokenMap(token);
            } catch (SignatureException | NoSuchAlgorithmException | JWTVerifyException | InvalidKeyException e) {
                e.printStackTrace();
            }

            final String login = (String) tokenMap.get("login");
            final String senha = (String) tokenMap.get("senha");

            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(login, senha));
            sendRedirect(servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void sendRedirect(ServletResponse servletResponse) throws IOException {
        final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect(getUrlRedirect());
    }

    protected abstract String getUrlRedirect();

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
