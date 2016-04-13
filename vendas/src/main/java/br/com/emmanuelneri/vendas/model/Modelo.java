package br.com.emmanuelneri.vendas.model;


import br.com.emmanuelneri.integrador.enuns.Marca;
import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.integrador.vo.ModeloVo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Modelo implements Model<Long> {

    @Id
    private Long id;

    @NotNull
    @Size(min = 1)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ModeloVo toVo() {
        final ModeloVo modeloVo = new ModeloVo();
        modeloVo.setId(this.id);
        modeloVo.setNome(this.nome);
        modeloVo.setMarca(marca);
        return modeloVo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modelo modelo = (Modelo) o;

        if (nome != null ? !nome.equals(modelo.nome) : modelo.nome != null) return false;
        return marca == modelo.marca;

    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        return result;
    }
}
