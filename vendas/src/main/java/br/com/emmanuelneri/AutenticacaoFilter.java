package br.com.emmanuelneri;

import br.com.emmanuelneri.portal.shiro.UsuarioPortalToken;
import com.auth0.jwt.JWTVerifyException;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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

public class AutenticacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final String token = servletRequest.getParameter("token");

            if(!Strings.isNullOrEmpty(token)) {
                final UsuarioPortalToken usuarioPortalToken = new UsuarioPortalToken(token);
                Subject subject = SecurityUtils.getSubject();
                subject.login(usuarioPortalToken);
                sendRedirect(servletResponse);
            }

        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException | JWTVerifyException ex) {
            ex.printStackTrace();
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    private void sendRedirect(ServletResponse servletResponse) throws IOException {
        final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect("/pedidos/home");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
