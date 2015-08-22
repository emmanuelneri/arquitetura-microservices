package br.com.emmanuelneri.vo;

import java.io.Serializable;

public final class VeiculoRankingVo implements Serializable {

    private VeiculoVo veiculo;
    private Long quantidade;

    public VeiculoVo getVeiculo() {
        return veiculo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setVeiculo(VeiculoVo veiculo) {
        this.veiculo = veiculo;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
