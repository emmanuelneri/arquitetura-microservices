package br.com.emmanuelneri.vendas.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

@JsonSerialize
public class MarcaVo implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaVo marcaVo = (MarcaVo) o;
        return Objects.equals(descricao, marcaVo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }
}
