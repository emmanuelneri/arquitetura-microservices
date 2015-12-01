package br.com.emmanuelneri;

import br.com.emmanuelneri.cadastros.model.Usuario;
import br.com.emmanuelneri.cadastros.service.UsuarioService;
import br.com.emmanuelneri.cadastros.shiro.UsuarioPortalToken;
import com.auth0.jwt.JWTVerifyException;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
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

public class AutenticacaoFilter implements Filter {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final String token = servletRequest.getParameter("token");

            if(!Strings.isNullOrEmpty(token)) {
                final UsuarioPortalToken usuarioPortalToken = new UsuarioPortalToken(token);

                try {
                    final Usuario usuario = usuarioService.atualizarUsuario(usuarioPortalToken.getUsuario().getEmail());
                    usuarioPortalToken.setUsuario(usuario);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

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
        httpResponse.sendRedirect("/cadastros/home");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
