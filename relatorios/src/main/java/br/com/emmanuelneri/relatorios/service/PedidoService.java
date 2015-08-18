package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.relatorios.util.anotations.CadastroClientWs;
import br.com.emmanuelneri.relatorios.util.anotations.VendasClientWS;
import br.com.emmanuelneri.relatorios.vo.ClienteRankingVo;
import br.com.emmanuelneri.relatorios.vo.ClienteVo;
import br.com.emmanuelneri.relatorios.vo.VeiculoRankingVo;
import br.com.emmanuelneri.relatorios.vo.VeiculoVo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
public class PedidoService implements Serializable {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @CadastroClientWs
    private WebTarget clientCadastrosWS;

    @Inject
    private ClienteService clienteService;

    @Inject
    private VeiculoService veiculoService;

    public List<ClienteRankingVo> findTopClientes() {
        final Map<Long, ClienteVo> clientesPorId = clienteService.findClientesPorId();

        final List<ClienteRankingVo> clienteRankingVos = clientVendasWS.path("/pedido/buscar/topClientes")
                .request().get(new GenericType<List<ClienteRankingVo>>() {});

        clienteRankingVos.forEach(clienteRankingVo
                -> clienteRankingVo.setCliente(clientesPorId.get(clienteRankingVo.getIdCliente())));

        return clienteRankingVos;
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
       final Map<Long, VeiculoVo> veiculosPorId = veiculoService.findVeiculosPorId();


        final List<VeiculoRankingVo> veiculoRankingVos = clientVendasWS.path("/pedido/buscar/topVeiculos")
                .request().get(new GenericType<List<VeiculoRankingVo>>() {});

        veiculoRankingVos.forEach(veiculoRankingVo
                -> veiculoRankingVo.setVeiculo(veiculosPorId.get(veiculoRankingVo.getIdVeiculo())));

        return veiculoRankingVos;
    }

}
