package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Aplicacao;
import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.UsuarioLogado;
import com.auth0.jwt.JWTSigner;
import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class MenuController {

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    public void redirectAplicacao(Aplicacao aplicacao) throws IOException {
        final Map<String, Object> mapValores = new HashMap<>();
        mapValores.put("email", getUsuario().getEmail());
        mapValores.put("id", getUsuario().getId());
        mapValores.put("chaveAplicacao", aplicacao.getChave());

        final String token = new JWTSigner("secret").sign(mapValores);
        Faces.redirect(aplicacao.getUrl()+"?token=%s&", token);
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
