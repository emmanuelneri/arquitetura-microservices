package br.com.emmanuelneri.cadastros.shiro;

import br.com.emmanuelneri.cadastros.model.Usuario;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioGenerico;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioPortalGenericoToken;
import com.auth0.jwt.JWTVerifyException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public final class UsuarioPortalToken extends UsuarioPortalGenericoToken {

    public UsuarioPortalToken(String token) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        super(token);
    }

    @Override
    public UsuarioGenerico criarUsuario(Map<String, Object> tokenMap) {
        return new Usuario(tokenMap);
    }

}