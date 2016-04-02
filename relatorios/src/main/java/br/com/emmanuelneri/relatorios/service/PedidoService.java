package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ItemPedidoVo;
import br.com.emmanuelneri.integrador.vo.PedidoVo;
import br.com.emmanuelneri.relatorios.model.Cliente;
import br.com.emmanuelneri.relatorios.model.ItemPedido;
import br.com.emmanuelneri.relatorios.model.Pedido;
import br.com.emmanuelneri.relatorios.model.Usuario;
import br.com.emmanuelneri.relatorios.model.Veiculo;
import br.com.emmanuelneri.relatorios.vo.ClienteRankingVo;
import br.com.emmanuelneri.relatorios.vo.VeiculoRankingVo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
public class PedidoService extends GenericService<Pedido, Long> {

    @Inject
    private ClienteService clienteService;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private VeiculoService veiculoService;

    @Transactional
    public void salvar(PedidoVo pedidoVo) {
        Pedido pedido = findByIdCompleto(pedidoVo.getId());
        if (pedido == null) {
            pedido = new Pedido();
            pedido.setId(pedidoVo.getId());
        }

        pedido.setDataCriacao(pedidoVo.getDataCriacao());
        pedido.setDataFinalizacao(pedidoVo.getDataFinalizacao());
        pedido.setValorTotal(pedidoVo.getValorTotal());

        final Cliente cliente = clienteService.findClienteOuCriaNovo(pedidoVo.getCliente());
        pedido.setCliente(cliente);

        final Usuario usuario = usuarioService.findUsuarioOuCriaNovo(pedidoVo.getUsuario());
        pedido.setUsuario(usuario);

        pedido.setItens(getItens(pedidoVo.getId(), pedidoVo.getItens()));
        pedido.setSituacaoPedido(pedidoVo.getSituacaoPedido());

        save(pedido);
    }

    private Pedido findByIdCompleto(Long id) {
        return getResultOrNull(getEntityManager().createNamedQuery("Pedido.findPedidoCompletoById", Pedido.class)
                .setParameter("id", id)
                .getResultList());
    }

    private List<ItemPedido> getItens(Long idPedido, List<ItemPedidoVo> itensVo) {
        deleteItens(idPedido);

        final List<ItemPedido> itemPedidos = new ArrayList<>();
        for (ItemPedidoVo vo : itensVo) {
            final Veiculo veiculo = veiculoService.findVeiculoOuCriaNovo(vo.getVeiculo());
            final ItemPedido itemPedido = new ItemPedido(vo.getId(), vo.getQuantidade(), vo.getValorUnitario(), vo.getValorTotal(), veiculo);
            itemPedidos.add(itemPedido);
        }
        return itemPedidos;
    }

    public void deleteItens(Long idPedido) {
        getEntityManager().createNamedQuery("Pedido.deleteItens")
                .setParameter("id", idPedido)
                .executeUpdate();
    }

    public List<ClienteRankingVo> findTopClientes() {
        return getEntityManager().createNamedQuery("Pedido.findTopClientes", ClienteRankingVo.class).getResultList();
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        return getEntityManager().createNamedQuery("Pedido.findTopVeiculo", VeiculoRankingVo.class).getResultList();
    }

}
