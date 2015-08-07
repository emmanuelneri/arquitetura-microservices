package br.com.emmanuelneri.cadastros.ws;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.cadastros.model.enuns.Marca;
import br.com.emmanuelneri.cadastros.service.ModeloService;
import br.com.emmanuelneri.cadastros.vo.ModeloVo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("modelo")
@Produces(MediaType.APPLICATION_JSON)
public class ModeloWs {

    @Inject
    private ModeloService modeloService;

    @GET
    @Path("buscar/todos")
    public Response buscarTodosClientes() {
        final List<Modelo> modelos = modeloService.findAll();
        return Response.ok(transformarClientesParaVo(modelos)).build();
    }

    private List<ModeloVo> transformarClientesParaVo(List<Modelo> modelos) {
        return modelos.stream().map(modelo ->
                new ModeloVo(modelo.getId(), modelo.getNome(), Marca.marcaToVo(modelo.getMarca().getDescricao()))).collect(Collectors.toList());
    }
}
