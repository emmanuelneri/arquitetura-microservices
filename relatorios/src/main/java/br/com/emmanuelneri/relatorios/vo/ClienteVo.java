package br.com.emmanuelneri.relatorios.vo;

import java.io.Serializable;

public class ClienteVo implements Serializable {

    private Long id;

    private String nome;

    private String cpfCnpj;

    public Long getId() {
        return id;
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
