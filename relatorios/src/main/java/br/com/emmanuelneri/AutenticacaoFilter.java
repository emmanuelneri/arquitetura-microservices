package br.com.emmanuelneri;

import br.com.emmanuelneri.integrador.autenticacao.AutenticacaoGenericoFilter;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioGenerico;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioPortalGenericoToken;
import br.com.emmanuelneri.relatorios.service.UsuarioService;
import br.com.emmanuelneri.relatorios.shiro.UsuarioPortalToken;
import com.auth0.jwt.JWTVerifyException;

import javax.inject.Inject;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class AutenticacaoFilter  extends AutenticacaoGenericoFilter {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public UsuarioPortalGenericoToken criarUsuario(String token) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        return new UsuarioPortalToken(token);
    }

    @Override
    public UsuarioGenerico atualizarUsuario(String email) {
        return usuarioService.atualizarUsuario(email);
    }

    @Override
    public String getUrlHome() {
        return "/relatorios/home";
    }
}
