package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.integrador.interfaces.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "modulo_uk", columnNames ={"nome"})
})
public class Modulo implements Model<Long> {

    public static final Modulo PORTAL = new Modulo(1L, "Portal", "P0RT4LL", "http://localhost:8080/portal/token/");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String nome;

    @NotNull
    private String chave;

    @NotNull
    @Column(length = 255)
    private String url;

    protected Modulo() {

    }

    private Modulo(Long id, String nome, String chave, String url) {
        this.id = id;
        this.nome = nome;
        this.chave = chave;
        this.url = url;
    }

    public Modulo(String nome, String chave, String url) {
        this.nome = nome;
        this.chave = chave;
        this.url = url;
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