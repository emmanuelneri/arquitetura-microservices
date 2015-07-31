package br.com.emmanuelneri.portal.util;

import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.shiro.ModuloVO;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TokenUsuarioUtil {

    public static String createToken(Usuario usuario, Modulo moduloSelecionado) {
        final Map<String, Object> mapValores = new HashMap<>();
        mapValores.put("email", usuario.getEmail());
        mapValores.put("id", usuario.getId());
        mapValores.put("nome", usuario.getNome());
        mapValores.put("chaveAplicacao", moduloSelecionado.getChave());
        mapValores.put("modulosUsuario", transformModuloToVo(usuario.getModulos()));

        return new JWTSigner("secret").sign(mapValores);
    }

    public static Map<String, Object> getTokenMap(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        return new JWTVerifier("secret").verify(token);
    }

    private static List<ModuloVO> transformModuloToVo(List<Modulo> modelos) {
        return modelos.stream().map(modulo -> new ModuloVO(modulo.getNome(),
                modulo.getChave(), modulo.getUrl())).collect(Collectors.toList());
    }

}
