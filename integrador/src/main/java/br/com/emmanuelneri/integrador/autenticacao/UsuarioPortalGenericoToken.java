package br.com.emmanuelneri.integrador.autenticacao;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.apache.shiro.authc.AuthenticationToken;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public abstract class UsuarioPortalGenericoToken implements AuthenticationToken {

    private final String chaveAplicacao;
    private UsuarioGenerico usuario;

    public UsuarioPortalGenericoToken(String token) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        final Map<String, Object> tokenMap = getTokenMap(token);

        usuario = criarUsuario(tokenMap);
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

    public UsuarioGenerico getUsuario() {
        return usuario;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }

    public void setUsuario(UsuarioGenerico usuario) {
        this.usuario = usuario;
    }

    public abstract UsuarioGenerico criarUsuario(Map<String, Object> tokenMap);
}
