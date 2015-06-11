package br.com.emmanuelneri.cadastros.model;

import br.com.emmanuelneri.cadastros.util.Model;

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

    public static final Modulo VENDAS = new Modulo(2L, "Vendas", "http://localhost:8080/cadastros/auth/", "SACRSC1234");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String nome;

    @NotNull
    @Column(length = 255)
    private String url;

    @NotNull
    private String chave;

    protected Modulo() {

    }

    public Modulo(Long id, String nome, String url, String chave) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.chave = chave;
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