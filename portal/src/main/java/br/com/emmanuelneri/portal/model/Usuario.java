package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.portal.util.Model;
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "usuario_uk", columnNames ={"email"})
})
@NamedQueries(value = {
        @NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u where u.email = :email"),
})
public class Usuario implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private String nome;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = new Sha256Hash(senha).toHex();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
