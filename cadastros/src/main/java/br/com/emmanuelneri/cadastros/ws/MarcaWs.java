package br.com.emmanuelneri.cadastros.ws;

import br.com.emmanuelneri.cadastros.model.enuns.Marca;
import br.com.emmanuelneri.cadastros.vo.MarcaVo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("marca")
@Produces(MediaType.APPLICATION_JSON)
public class MarcaWs {

    @GET
    @Path("buscar/todos")
    public Response buscarTodasMarcas() {
        return Response.ok(getMarcas()).build();
    }

    private List<MarcaVo> getMarcas() {
        return Arrays.asList(Marca.values()).stream()
                .map(marca -> new MarcaVo(marca.getDescricao())).collect(Collectors.toList());
    }
}
