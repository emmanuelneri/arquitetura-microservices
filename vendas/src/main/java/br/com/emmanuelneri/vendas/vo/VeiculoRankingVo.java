package br.com.emmanuelneri.vendas.vo;

public final class VeiculoRankingVo {

    private final Long idVeiculo;
    private final Long quantidade;

    public VeiculoRankingVo(Long idVeiculo, Long quantidade) {
        this.idVeiculo = idVeiculo;
        this.quantidade = quantidade;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
