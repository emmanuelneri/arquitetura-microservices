package br.com.emmanuelneri.integrador.vo;

import br.com.emmanuelneri.integrador.enuns.Marca;

import java.io.Serializable;
import java.util.Objects;

public class ModeloVo implements Serializable {

    private Long id;

    private String nome;

    private Marca marca;

    public ModeloVo() {
    }

    public ModeloVo(Long id, String nome, Marca marca) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloVo modeloVo = (ModeloVo) o;
        return Objects.equals(id, modeloVo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
