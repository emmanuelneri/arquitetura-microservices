package br.com.emmanuelneri.integrador.autenticacao;

import br.com.emmanuelneri.integrador.interfaces.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "modulo_uk", columnNames ={"nome"})
})
public abstract class ModuloGenerico implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(length = 50)
    protected String nome;

    @NotNull
    @Column(length = 255)
    protected String url;

    @NotNull
    protected String chave;

    protected ModuloGenerico() {
    }

    public ModuloGenerico(Long id, String nome, String url, String chave) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }
}