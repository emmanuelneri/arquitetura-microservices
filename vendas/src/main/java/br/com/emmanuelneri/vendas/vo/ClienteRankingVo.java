package br.com.emmanuelneri.vendas.vo;

import br.com.emmanuelneri.portal.model.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ClienteRankingVo implements Serializable {

    private final Cliente cliente;
    private final Long quantidadeVeiculo;
    private final BigDecimal valorTotal;

    public ClienteRankingVo(Cliente cliente, Long quantidadeVeiculo, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.quantidadeVeiculo = quantidadeVeiculo;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Long getQuantidadeVeiculo() {
        return quantidadeVeiculo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
