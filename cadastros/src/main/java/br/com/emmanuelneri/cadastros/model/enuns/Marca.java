package br.com.emmanuelneri.cadastros.model.enuns;

import br.com.emmanuelneri.cadastros.vo.MarcaVo;

public enum Marca {

    AUDI("Audi"),
    BMW("BMW"),
    CHEVROLET("Chevrolet"),
    VOLKSWAGEN("Volkswagen"),
    FIAT("Fiat"),
    FORD("Ford"),
    LAND_ROVER("Land Rover"),
    MERCEDES("Mercedes"),
    KIA("KIA");

    private final String descricao;

    Marca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static MarcaVo marcaToVo(String descricao) {
        return new MarcaVo(descricao);
    }
}
