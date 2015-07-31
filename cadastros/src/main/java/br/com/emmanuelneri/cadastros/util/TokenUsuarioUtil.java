package br.com.emmanuelneri.cadastros.util;

import br.com.emmanuelneri.cadastros.shiro.ModuloVO;
import br.com.emmanuelneri.cadastros.shiro.UsuarioVO;
import com.auth0.jwt.JWTSigner;

import java.util.HashMap;
import java.util.Map;

public final class TokenUsuarioUtil {

    public static String createToken(UsuarioVO usuario, ModuloVO moduloSelecionado) {
        final Map<String, Object> mapValores = new HashMap<>();
        mapValores.put("email", usuario.getEmail());
        mapValores.put("id", usuario.getId());
        mapValores.put("nome", usuario.getNome());
        mapValores.put("chaveAplicacao", moduloSelecionado.getChave());
        mapValores.put("modulosUsuario", usuario.getModulos());

        return new JWTSigner("secret").sign(mapValores);
    }

}
