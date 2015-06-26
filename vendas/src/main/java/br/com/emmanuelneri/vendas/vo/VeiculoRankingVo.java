package br.com.emmanuelneri.vendas.vo;

import br.com.emmanuelneri.vendas.model.Veiculo;

public final class VeiculoRankingVo {

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
