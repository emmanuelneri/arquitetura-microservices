package br.com.emmanuelneri.relatorios.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ClienteRankingVo implements Serializable {

    private Long idCliente;
    private Long quantidadeVeiculo;
    private BigDecimal valorTotal;

    private ClienteVo cliente;

    public ClienteVo getCliente() {
        return cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Long getQuantidadeVeiculo() {
        return quantidadeVeiculo;
    }

    public void setCliente(ClienteVo cliente) {
        this.cliente = cliente;
    }

    public void setQuantidadeVeiculo(Long quantidadeVeiculo) {
        this.quantidadeVeiculo = quantidadeVeiculo;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
