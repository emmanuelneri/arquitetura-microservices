package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.integrador.autenticacao.ModuloGenerico;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "modulo_uk", columnNames ={"nome"})
})
public class Modulo extends ModuloGenerico {

    public static final Modulo PORTAL = new Modulo(1L, "Portal", "P0RT4LL", "http://localhost:8080/portal/token/");

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
        return Objects.equals(id, modulo.id) &&
                Objects.equals(nome, modulo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}