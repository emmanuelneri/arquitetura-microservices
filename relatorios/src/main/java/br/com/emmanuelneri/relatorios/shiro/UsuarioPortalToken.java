package br.com.emmanuelneri.relatorios.shiro;

import br.com.emmanuelneri.integrador.autenticacao.UsuarioGenerico;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioPortalGenericoToken;
import br.com.emmanuelneri.relatorios.model.Usuario;
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
