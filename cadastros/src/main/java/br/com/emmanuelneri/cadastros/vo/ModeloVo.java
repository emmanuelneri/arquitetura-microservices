package br.com.emmanuelneri.cadastros.vo;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class ModeloVo implements Serializable {

    private Long id;

    private String nome;

    private MarcaVo marca;

    public ModeloVo() {
    }

    public ModeloVo(Long id, String nome, MarcaVo marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public MarcaVo getMarca() {
        return marca;
    }

}
