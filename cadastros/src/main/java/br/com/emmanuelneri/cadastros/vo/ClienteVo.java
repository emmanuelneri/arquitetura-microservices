package br.com.emmanuelneri.cadastros.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

@JsonSerialize
public class ClienteVo implements Serializable {

    private Long id;

    private String nome;

    private String cpfCnpj;

    public ClienteVo() {
    }

    public ClienteVo(Long id, String nome, String cpfCnpj) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
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
