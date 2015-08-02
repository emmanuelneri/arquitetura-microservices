package br.com.emmanuelneri.vendas.vo;

import java.io.Serializable;

public final class MarcaVo implements Serializable {

    private String descricao;

    public MarcaVo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
