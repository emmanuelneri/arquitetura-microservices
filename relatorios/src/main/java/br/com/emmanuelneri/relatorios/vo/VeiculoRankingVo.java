package br.com.emmanuelneri.relatorios.vo;

import br.com.emmanuelneri.relatorios.model.Veiculo;

import java.io.Serializable;

public final class VeiculoRankingVo implements Serializable {

    private Veiculo veiculo;
    private Long quantidade;

    public VeiculoRankingVo(Veiculo veiculo, Long quantidade) {
        this.veiculo = veiculo;
        this.quantidade = quantidade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
