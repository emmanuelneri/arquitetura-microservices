package br.com.emmanuelneri.vendas.ws;

import br.com.emmanuelneri.vendas.service.PedidoService;
import br.com.emmanuelneri.vendas.vo.ClienteRankingVo;
import br.com.emmanuelneri.vendas.vo.VeiculoRankingVo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pedido")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidosWs {

    @Inject
    private PedidoService pedidoService;

    @GET
    @Path("buscar/topClientes")
    public Response buscarTopClientes() {
        final List<ClienteRankingVo> topClientes = pedidoService.findTopClientes();
        return Response.ok(topClientes).build();
    }

    @GET
    @Path("buscar/topVeiculos")
    public Response buscarTopVeiculos() {
        final List<VeiculoRankingVo> topVeiculos = pedidoService.findTopVeiculos();
        return Response.ok(topVeiculos).build();
    }

}
