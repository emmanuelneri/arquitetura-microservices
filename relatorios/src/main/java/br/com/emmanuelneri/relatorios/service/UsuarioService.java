package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.anotations.PortalClientWS;
import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.UsuarioVo;
import br.com.emmanuelneri.relatorios.model.Usuario;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.client.WebTarget;

@Named
public class UsuarioService extends GenericService<Usuario, Long> {

    @Inject
    @PortalClientWS
    private WebTarget webTarget;

    @Transactional
    public Usuario atualizarUsuario(String email) {
        final Usuario usuarioPortal = webTarget.path("/usuario/buscar/").path(email).request().get(Usuario.class);
        final Usuario usuarioBanco = findByEmail(usuarioPortal.getEmail());

        if (usuarioBanco != null && usuarioBanco.getVersion() == usuarioPortal.getVersion()) {
            return usuarioBanco;
        }

        save(usuarioPortal);

        return usuarioPortal;
    }

    public Usuario findByEmail(String email) {
        return getResultOrNull(getEntityManager().createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", email)
                .getResultList());
    }

    public Usuario findUsuarioOuCriaNovo(UsuarioVo usuarioVo) {
        Usuario usuario = findById(usuarioVo.getId());

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setId(usuarioVo.getId());
            usuario.setNome(usuarioVo.getNome());
            usuario.setEmail(usuarioVo.getEmail());
            getEntityManager().persist(usuario);
        }
        return usuario;
    }
}
