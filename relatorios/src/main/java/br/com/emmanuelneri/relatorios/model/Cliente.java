package br.com.emmanuelneri.relatorios.model;

import br.com.emmanuelneri.integrador.interfaces.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente implements Model<Long> {

    @Id
    private Long id;

    @NotNull
    @Size(min = 1)
    private String nome;

    @NotNull
    @Size(min = 1)
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
