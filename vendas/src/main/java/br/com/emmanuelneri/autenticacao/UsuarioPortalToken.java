package br.com.emmanuelneri.autenticacao;

import br.com.emmanuelneri.vendas.model.Usuario;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.apache.shiro.authc.AuthenticationToken;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public final class UsuarioPortalToken implements AuthenticationToken {

    private final String chaveAplicacao;
    private Usuario usuario;

    public UsuarioPortalToken(String token) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        final Map<String, Object> tokenMap = getTokenMap(token);

        usuario = new Usuario(tokenMap);
        chaveAplicacao = (String) tokenMap.get("chaveAplicacao");
    }

    public Map<String, Object> getTokenMap(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        return new JWTVerifier("secret").verify(token);
    }

    @Override
    public String getPrincipal() {
        return usuario.getEmail();
    }

    @Override
    public Long getCredentials() {
        return usuario.getId();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
