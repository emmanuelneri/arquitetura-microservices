package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modulo;
import br.com.emmanuelneri.cadastros.model.Usuario;
import br.com.emmanuelneri.integrador.anotations.PortalClientWS;
import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.UsuarioVo;
import com.google.common.base.Strings;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.client.WebTarget;
import java.util.stream.Collectors;

@Named
public class UsuarioService extends GenericService<Usuario, Long> {

    @Inject
    @PortalClientWS
    private WebTarget webTarget;

    @Transactional
    public Usuario atualizarUsuario(String email) {
        final UsuarioVo usuarioVo = webTarget.path("/usuario/buscar/").path(email).request().get(UsuarioVo.class);
        return findUsuarioOuCriaNovo(usuarioVo);
    }

    private Usuario findUsuarioOuCriaNovo(UsuarioVo usuarioVo) {
        Usuario usuario = findById(usuarioVo.getId());

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setId(usuarioVo.getId());
        }

        if(!Strings.isNullOrEmpty(usuarioVo.getNome())) {
            usuario.setNome(usuarioVo.getNome());
        }

        if(!Strings.isNullOrEmpty(usuarioVo.getEmail())) {
            usuario.setEmail(usuarioVo.getEmail());
        }

        if(usuarioVo.getModulos() != null) {
            usuario.setModulos(usuarioVo.getModulos().stream()
                    .map(vo -> new Modulo(vo.getId(), vo.getNome(), vo.getUrl(), vo.getChave())).collect(Collectors.toList()));
        }

        save(usuario);

        return usuario;
    }
}
