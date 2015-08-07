package br.com.emmanuelneri.cadastros.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class VeiculoVo implements Serializable {

    private Long id;

    private String nome;

    private ModeloVo modelo;

    public VeiculoVo() {
    }

    public VeiculoVo(Long id, String nome, ModeloVo modelo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ModeloVo getModelo() {
        return modelo;
    }
}
