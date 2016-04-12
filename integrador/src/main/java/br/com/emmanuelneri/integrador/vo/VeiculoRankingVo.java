package br.com.emmanuelneri.integrador.vo;

import java.io.Serializable;

public final class VeiculoRankingVo implements Serializable {

    private VeiculoVo veiculo;
    private Long idVeiculo;
    private Long quantidade;

    public VeiculoRankingVo() {
    }

    public VeiculoRankingVo(Long idVeiculo, Long quantidade) {
        this.idVeiculo = idVeiculo;
        this.quantidade = quantidade;
    }

    public VeiculoVo getVeiculo() {
        return veiculo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
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
