package br.com.emmanuelneri.relatorios.vo;

import br.com.emmanuelneri.relatorios.model.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ClienteRankingVo implements Serializable {

    private Cliente cliente;
    private Long quantidadeVeiculo;
    private BigDecimal valorTotal;

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
