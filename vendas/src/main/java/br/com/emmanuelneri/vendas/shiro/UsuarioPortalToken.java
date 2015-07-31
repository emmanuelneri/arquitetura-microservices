package br.com.emmanuelneri.vendas.shiro;

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
    private UsuarioVO usuario;

    public UsuarioPortalToken(String token) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        final Map<String, Object> tokenMap = getTokenMap(token);

        usuario = new UsuarioVO(tokenMap);
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

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }
}
