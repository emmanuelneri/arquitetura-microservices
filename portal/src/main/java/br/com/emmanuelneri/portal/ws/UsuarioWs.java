package br.com.emmanuelneri.portal.ws;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.service.UsuarioService;
import br.com.emmanuelneri.portal.ws.json.UsuarioJson;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioWs {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Path("buscar/{emailUsuarioLogado}")
    public Response buscarUsuario(@PathParam("emailUsuarioLogado") String email) {
        final Usuario usuario = usuarioService.findCompletoByEmail(email);
        return Response.ok(new UsuarioJson(usuario)).build();
    }


}
