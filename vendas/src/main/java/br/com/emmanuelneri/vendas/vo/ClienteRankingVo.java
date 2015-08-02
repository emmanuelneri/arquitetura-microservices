package br.com.emmanuelneri.vendas.vo;

import java.math.BigDecimal;

public final class ClienteRankingVo {

    private final Long idCliente;
    private final Long quantidadeVeiculo;
    private final BigDecimal valorTotal;

    public ClienteRankingVo(Long idCliente, Long quantidadeVeiculo, BigDecimal valorTotal) {
        this.idCliente = idCliente;
        this.quantidadeVeiculo = quantidadeVeiculo;
        this.valorTotal = valorTotal;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Long getQuantidadeVeiculo() {
        return quantidadeVeiculo;
    }
}
