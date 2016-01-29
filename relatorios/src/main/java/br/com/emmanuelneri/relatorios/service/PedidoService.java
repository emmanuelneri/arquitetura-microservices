package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.anotations.CadastroClientWs;
import br.com.emmanuelneri.integrador.anotations.VendasClientWs;
import br.com.emmanuelneri.integrador.vo.ClienteRankingVo;
import br.com.emmanuelneri.integrador.vo.VeiculoRankingVo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.List;

@Named
public class PedidoService implements Serializable {

    @Inject
    @VendasClientWs
    private WebTarget clientVendasWS;

    @Inject
    @CadastroClientWs
    private WebTarget clientCadastrosWS;

    @Inject
    private ClienteService clienteService;

    @Inject
    private VeiculoService veiculoService;

    public List<ClienteRankingVo> findTopClientes() {
        final List<ClienteRankingVo> clienteRankingVos = clientVendasWS.path("/pedido/buscar/topClientes")
                .request().get(new GenericType<List<ClienteRankingVo>>() {});

        clienteRankingVos.forEach(clienteRankingVo
                -> clienteRankingVo.setCliente(clienteRankingVo.getCliente()));

        return clienteRankingVos;
    }

    public List<VeiculoRankingVo> findTopVeiculos() {
        final List<VeiculoRankingVo> veiculoRankingVos = clientVendasWS.path("/pedido/buscar/topVeiculos")
                .request().get(new GenericType<List<VeiculoRankingVo>>() {});

        veiculoRankingVos.forEach(veiculoRankingVo
                -> veiculoRankingVo.setVeiculo(veiculoRankingVo.getVeiculo()));

        return veiculoRankingVos;
    }

}
