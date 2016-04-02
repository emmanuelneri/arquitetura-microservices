package br.com.emmanuelneri.integrador.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPedidoVo implements Serializable {

    private Long id;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private VeiculoVo veiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public VeiculoVo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoVo veiculo) {
        this.veiculo = veiculo;
    }
}
