package br.com.emmanuelneri.vendas.model;

import br.com.emmanuelneri.integrador.autenticacao.ModuloGenerico;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Modulo extends ModuloGenerico {

    public static final Modulo VENDAS = new Modulo(2L, "Vendas", "http://localhost:8080/vendas/auth/", "SACRSC1234");

    protected Modulo() {
    }

    public Modulo(Long id, String nome, String url, String chave) {
       super(id, nome, url, chave);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getChave() {
        return chave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(id, modulo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}