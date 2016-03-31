package br.com.emmanuelneri.relatorios.ws;

import br.com.emmanuelneri.relatorios.model.Pedido;
import br.com.emmanuelneri.relatorios.service.PedidoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("pedidos")
@Consumes(MediaType.APPLICATION_JSON)
public class PedidosWs {

    @Inject
    private PedidoService pedidoService;

    @PUT
    @Path("pedido/atualizar")
    public void atualizarPedidos(Pedido pedido) {
        pedidoService.save(pedido);
    }
}
