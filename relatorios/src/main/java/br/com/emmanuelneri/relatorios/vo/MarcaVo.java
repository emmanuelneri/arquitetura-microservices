package br.com.emmanuelneri.relatorios.vo;

import java.util.Objects;

public final class MarcaVo {

    private String descricao;

    public MarcaVo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
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
