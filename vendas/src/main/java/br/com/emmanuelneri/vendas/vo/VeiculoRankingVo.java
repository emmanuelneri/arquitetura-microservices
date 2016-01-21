package br.com.emmanuelneri.vendas.vo;

import br.com.emmanuelneri.cadastros.model.Veiculo;

import java.io.Serializable;

public final class VeiculoRankingVo implements Serializable {

    private final Veiculo veiculo;
    private final Long quantidade;

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
