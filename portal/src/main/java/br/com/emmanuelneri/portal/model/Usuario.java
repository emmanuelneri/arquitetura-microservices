package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.integrador.autenticacao.UsuarioGenerico;
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
public class Usuario extends UsuarioGenerico {

    @NotNull
    private String senha;

    @ManyToMany
    @JoinTable(name="usuario_modulo",
            joinColumns= @JoinColumn(name="id_usuario", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_modulo", referencedColumnName="id"))
    private List<Modulo> modulos = Collections.singletonList(Modulo.PORTAL);

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

    public List<Modulo> getModulos() {
        return modulos;
    }

    public List<Modulo> getModulosMenu() {
        List<Modulo> modulosMenu = modulos;
        modulosMenu.remove(Modulo.PORTAL);
        return modulos;
    }

    public long getVersion() {
        return version;
    }
}
