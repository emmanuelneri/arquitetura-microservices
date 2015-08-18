package br.com.emmanuelneri.relatorios.util;

import br.com.emmanuelneri.relatorios.shiro.ModuloVO;
import br.com.emmanuelneri.relatorios.shiro.UsuarioVO;
import com.auth0.jwt.JWTSigner;

import java.util.HashMap;
import java.util.Map;

public final class TokenUsuarioUtil {

    public static String createToken(UsuarioVO usuarioMenu, ModuloVO moduloMenu) {
        final Map<String, Object> mapValores = new HashMap<>();
        mapValores.put("email", usuarioMenu.getEmail());
        mapValores.put("id", usuarioMenu.getId());
        mapValores.put("nome", usuarioMenu.getNome());
        mapValores.put("chaveAplicacao", moduloMenu.getChave());
        mapValores.put("modulosUsuario", usuarioMenu.getModulos());

        return new JWTSigner("secret").sign(mapValores);
    }

}
