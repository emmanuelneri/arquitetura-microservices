package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.menu.model.ModuloMenu;
import br.com.emmanuelneri.portal.util.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "modulo_uk", columnNames ={"nome"})
})
public class Modulo implements Model<Long>, ModuloMenu {

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getChave() {
        return chave;
    }
}