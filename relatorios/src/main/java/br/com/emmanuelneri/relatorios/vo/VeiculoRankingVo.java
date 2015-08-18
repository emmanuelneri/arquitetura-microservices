package br.com.emmanuelneri.relatorios.vo;

import java.io.Serializable;

public final class VeiculoRankingVo implements Serializable {


    private Long idVeiculo;
    private Long quantidade;

    private VeiculoVo veiculo;

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

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}
