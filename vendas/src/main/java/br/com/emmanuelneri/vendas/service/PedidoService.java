package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.vendas.exception.ValidationException;
import br.com.emmanuelneri.vendas.model.Pedido;
import br.com.emmanuelneri.vendas.model.enuns.SituacaoPedido;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Named
public class PedidoService extends GenericService<Pedido, Long> {

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Transactional
    public void salvar(Pedido pedido) throws ValidationException {

        if(pedido.getCliente() == null) {
            throw new ValidationException("O pedido deve conter um cliente");
        }

        if(pedido.getItens().isEmpty()) {
            throw new ValidationException("O pedido deve conter ao menos um item");
        }

        if(!pedido.isPedidoEditavel()) {
            throw new ValidationException("Apenas pedidos abertos podem ser alterados");
        }

        save(pedido);
        enviarPedido(pedido);
    }

    private void enviarPedido(Pedido pedido) {
        clienteRelatorioWS.path("/pedidos/pedido/atualizar").queryParam("pedido", pedido)
                .request().put(Entity.entity(pedido, MediaType.APPLICATION_JSON));
    }

    @Transactional
    public void finalizar(Pedido pedido) {
        pedido.setDataFinalizacao(LocalDate.now());
        pedido.setSituacaoPedido(SituacaoPedido.FINALIZADO);
        save(pedido);
    }

    public Pedido findPedidoCompletoById(Long id) {
        @SuppressWarnings("unchecked")
        final List<Pedido> pedidos = getEntityManager().createNamedQuery("Pedido.findPedidoCompletoById")
                .setParameter("id", id).getResultList();

        return getResultOrNull(pedidos);
    }
}
