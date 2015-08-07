package br.com.emmanuelneri.vendas.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaVo getMarca() {
        return marca;
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
