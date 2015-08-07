package br.com.emmanuelneri.vendas.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

@JsonSerialize
public class ClienteVo implements Serializable {

    private Long id;

    private String nome;

    private String cpfCnpj;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteVo clienteVo = (ClienteVo) o;
        return Objects.equals(id, clienteVo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
