package br.com.emmanuelneri.integrador.autenticacao;

import br.com.emmanuelneri.integrador.vo.ModuloVO;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.omnifaces.util.Faces;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
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

    public static Map<String, Object> getTokenMap(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        return new JWTVerifier("secret").verify(token);
    }

    public static void redirectAplicacao(UsuarioVO usuario, ModuloVO modulo) throws IOException {
        final String token = TokenUsuarioUtil.createToken(usuario, modulo);
        Faces.redirect(modulo.getUrl() + "?token=%s&", token);
    }

}
