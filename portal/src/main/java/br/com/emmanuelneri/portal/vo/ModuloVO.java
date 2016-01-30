package br.com.emmanuelneri.portal.vo;

import java.util.Objects;

public class ModuloVO {

    private final String nome;
    private final String chave;
    private final String url;

    public ModuloVO(String nome, String chave, String url) {
        this.nome = nome;
        this.chave = chave;
        this.url = url;
    }

    public String getNome() {
        return this.nome;
    }

    public String getChave() {
        return this.chave;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            ModuloVO moduloVO = (ModuloVO)o;
            return Objects.equals(this.nome, moduloVO.nome);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.nome});
    }

}
