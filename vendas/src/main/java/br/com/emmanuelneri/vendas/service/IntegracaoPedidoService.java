package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.vendas.model.Pedido;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class IntegracaoPedidoService {

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Asynchronous
    public void enviarPedido(Pedido pedido) {
        clienteRelatorioWS.path("/pedidos/pedido/atualizar").queryParam("pedido", pedido.toVo())
                .request().put(Entity.entity(pedido.toVo(), MediaType.APPLICATION_JSON));
    }

}
