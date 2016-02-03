package br.com.emmanuelneri.portal.util;

import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;
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

    public static String createToken(Usuario usuario) {
        HashMap mapValores = new HashMap();
        mapValores.put("login", usuario.getEmail());
        mapValores.put("senha", usuario.getSenha());
        return (new JWTSigner("secret")).sign(mapValores);
    }

    public static Map<String, Object> getTokenMap(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        return (new JWTVerifier("secret")).verify(token);
    }

    public static void redirectAplicacao(Usuario usuario, Modulo modulo) throws IOException {
        String token = createToken(usuario);
        Faces.redirect(modulo.getUrl() + "?token=%s&", token);
    }

}
