package br.com.emmanuelneri.integrador.vo;

import java.io.Serializable;
import java.util.List;

public class UsuarioVo implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private List<ModuloVo> modulos;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ModuloVo> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloVo> modulos) {
        this.modulos = modulos;
    }
}
