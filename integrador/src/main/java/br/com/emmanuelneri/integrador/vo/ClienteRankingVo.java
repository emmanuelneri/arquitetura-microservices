package br.com.emmanuelneri.integrador.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ClienteRankingVo implements Serializable {

    private ClienteVo cliente;
    private Long idCliente;
    private Long quantidadeVeiculo;
    private BigDecimal valorTotal;

    public ClienteRankingVo() {
    }

    public ClienteRankingVo(Long idCliente, Long quantidadeVeiculo, BigDecimal valorTotal) {
        this.idCliente = idCliente;
        this.quantidadeVeiculo = quantidadeVeiculo;
        this.valorTotal = valorTotal;
    }

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
}
