package br.com.emmanuelneri.cadastros.ws;

import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.cadastros.service.VeiculoService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("veiculo")
@Produces(MediaType.APPLICATION_JSON)
public class VeiculoWs {

    @Inject
    private VeiculoService veiculoService;

    @GET
    @Path("buscar/todos")
    public Response buscarTodosClientes() {
        final List<Veiculo> veiculos = veiculoService.findAll();
        return Response.ok(transformarClientesParaVo(veiculos)).build();
    }

    @GET
    @Path("buscar/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        final Veiculo veiculo = veiculoService.findById(id);
        return Response.ok(toVo(veiculo)).build();
    }

    private List<VeiculoVo> transformarClientesParaVo(List<Veiculo> veiculos) {
        return veiculos.stream().map(this::toVo).collect(Collectors.toList());
    }

    private VeiculoVo toVo(Veiculo veiculo) {
        return new VeiculoVo(veiculo.getId(), veiculo.getNome(), veiculo.getModelo().toVO());
    }

}
