package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.exception.ValidationException;
import br.com.emmanuelneri.vendas.model.Pedido;
import br.com.emmanuelneri.vendas.model.enuns.SituacaoPedido;
import br.com.emmanuelneri.vendas.util.GenericService;
import br.com.emmanuelneri.vendas.vo.ClienteRankingVo;
import br.com.emmanuelneri.vendas.vo.ClienteVo;
import br.com.emmanuelneri.vendas.vo.VeiculoRankingVo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Named
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

        final Pedido pedido = getResultOrNull(pedidos);
        if(pedido != null) {
            carregarVosDoPedido(pedido);
        }

        return pedido;
    }

    public List<Pedido> findAllCompleto() {
        final List<Pedido> pedidos = findAll();
        pedidos.stream().forEach(this::carregarVosDoPedido);
        return pedidos;
    }

    private void carregarVosDoPedido(Pedido pedido) {
        pedido.setCliente(clienteService.findById(pedido.getIdCliente()));

        pedido.getItens().stream().forEach(itemPedido
                -> itemPedido.setVeiculo(veiculoService.findById(itemPedido.getIdVeiculo())));
    }

    public List<ClienteRankingVo> findTopClientes() {
        return getEntityManager().createNamedQuery("Pedido.findTopClientes", ClienteRankingVo.class).getResultList();
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        return getEntityManager().createNamedQuery("Pedido.findTopVeiculo", VeiculoRankingVo.class).getResultList();
    }
}
