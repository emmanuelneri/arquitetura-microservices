package br.com.emmanuelneri.vendas.model;

import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Veiculo implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1)
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public VeiculoVo toVo() {
        final VeiculoVo veiculoVo = new VeiculoVo();
        veiculoVo.setId(this.id);
        veiculoVo.setNome(this.nome);
        veiculoVo.setModelo(modelo.toVo());
        return veiculoVo;
    }
}
