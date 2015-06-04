package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.model.Usuario;
import br.com.emmanuelneri.autenticacao.UsuarioPortalToken;
import br.com.emmanuelneri.vendas.util.GenericService;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class UsuarioService extends GenericService<Usuario> {

    @Transactional
    public void atualizarUsuario(UsuarioPortalToken usuarioPortalToken) {
        final Usuario usuarioToken = usuarioPortalToken.getUsuario();
        final Usuario usuarioBanco = findById(usuarioToken.getId());

        if(usuarioBanco != null && usuarioBanco.getVersion() == usuarioToken.getVersion()) {
            return;
        }

        save(usuarioPortalToken.getUsuario());
    }
}
