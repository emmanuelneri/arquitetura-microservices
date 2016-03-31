package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.relatorios.model.Pedido;
import br.com.emmanuelneri.relatorios.vo.ClienteRankingVo;
import br.com.emmanuelneri.relatorios.vo.VeiculoRankingVo;

import javax.inject.Named;
import java.util.List;

@Named
public class PedidoService extends GenericService<Pedido, Long> {

    public List<ClienteRankingVo> findTopClientes() {
        return getEntityManager().createNamedQuery("Pedido.findTopClientes", ClienteRankingVo.class).getResultList();
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        return getEntityManager().createNamedQuery("Pedido.findTopVeiculo", VeiculoRankingVo.class).getResultList();
    }

}
