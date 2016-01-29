package br.com.emmanuelneri.integrador.vo;

import java.io.Serializable;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModeloVo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloVo modelo) {
        this.modelo = modelo;
    }
}
