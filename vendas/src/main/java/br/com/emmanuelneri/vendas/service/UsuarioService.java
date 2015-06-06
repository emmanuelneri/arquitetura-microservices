package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.model.Usuario;
import br.com.emmanuelneri.vendas.util.GenericService;
import br.com.emmanuelneri.vendas.util.anotations.ClientWs;

import javax.ejb.Asynchronous;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.client.WebTarget;

@Named
public class UsuarioService extends GenericService<Usuario> {

    @Inject
    @ClientWs
    private WebTarget webTarget;

    @Asynchronous
    @Transactional
    public void atualizarUsuario(String email) {
        final Usuario usuarioPortal = webTarget.path("/usuario/buscar/").path(email).request().get(Usuario.class);
        final Usuario usuarioBanco = findById(usuarioPortal.getId());

        if(usuarioBanco != null && usuarioBanco.getVersion() == usuarioPortal.getVersion()) {
            return;
        }

        save(usuarioPortal);
    }
}
