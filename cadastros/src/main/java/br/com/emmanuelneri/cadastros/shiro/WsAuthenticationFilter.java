package br.com.emmanuelneri.cadastros.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.core.Response;

public class WsAuthenticationFilter extends AuthenticatingFilter {

    private String usernameParam;
    private String passwordParam;
    private String urlPattern;

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        final String username = getParametro(request, "email");
        final String password = getParametro(request, "senha");
        return createToken(username, password, request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean auth = executeLogin(request, response);

        if (!auth) {
            WebUtils.toHttp(response).sendError(Response.Status.UNAUTHORIZED.getStatusCode(),
                    "ERRO, Autenticação necessária");
        }

        return auth;
    }

    private String getParametro(ServletRequest request, String parametro) {
        return request.getParameter(parametro);
    }

    public String getUsernameParam() {
        return usernameParam;
    }

    public void setUsernameParam(String usernameParam) {
        this.usernameParam = usernameParam;
    }

    public String getPasswordParam() {
        return passwordParam;
    }

    public void setPasswordParam(String passwordParam) {
        this.passwordParam = passwordParam;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

}
