package br.com.emmanuelneri.vendas.vo;

import java.io.Serializable;

public class ModeloVo implements Serializable {

    private Long id;

    private String nome;

    private MarcaVo marca;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaVo getMarca() {
        return marca;
    }

    public void setMarca(MarcaVo marca) {
        this.marca = marca;
    }

}
