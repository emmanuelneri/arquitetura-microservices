package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.cadastros.service.ClienteService;
import br.com.emmanuelneri.cadastros.service.VeiculoService;
import br.com.emmanuelneri.portal.model.Pedido;
import br.com.emmanuelneri.portal.model.enuns.SituacaoPedido;
import br.com.emmanuelneri.portal.util.GenericService;
import br.com.emmanuelneri.portal.vo.ClienteRankingVo;
import br.com.emmanuelneri.portal.vo.VeiculoRankingVo;
import br.com.emmanuelneri.vendas.exception.ValidationException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class PedidoService extends GenericService<Pedido, Long> {

    @Inject
    private ClienteService clienteService;

    @Inject
    private VeiculoService veiculoService;

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
    }

    @Transactional
    public void finalizar(Pedido pedido) {
        pedido.setDataFinalizacao(LocalDate.now());
        pedido.setSituacaoPedido(SituacaoPedido.FINALIZADO);
        save(pedido);
    }

    public Pedido findPedidoCompletoById(Long id) {
        final List<Pedido> pedidos = getEntityManager().createNamedQuery("Pedido.findPedidoCompletoById", Pedido.class)
                .setParameter("id", id).getResultList();

        return getResultOrNull(pedidos);
    }

    public List<ClienteRankingVo> findTopClientes() {
        return getEntityManager().createNamedQuery("Pedido.findTopClientes", ClienteRankingVo.class).getResultList();
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        return getEntityManager().createNamedQuery("Pedido.findTopVeiculo", VeiculoRankingVo.class).getResultList();
    }
}
