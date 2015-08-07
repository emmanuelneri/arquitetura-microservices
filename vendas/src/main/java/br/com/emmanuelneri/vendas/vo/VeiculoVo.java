package br.com.emmanuelneri.vendas.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

@JsonSerialize
public class VeiculoVo implements Serializable {

    private Long id;

    private String nome;

    private ModeloVo modelo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoVo veiculoVo = (VeiculoVo) o;
        return Objects.equals(id, veiculoVo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
