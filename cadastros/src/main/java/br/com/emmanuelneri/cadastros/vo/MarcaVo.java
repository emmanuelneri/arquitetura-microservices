package br.com.emmanuelneri.cadastros.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public final class MarcaVo implements Serializable {

    private String descricao;

    public MarcaVo() {
    }

    public MarcaVo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
