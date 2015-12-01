package br.com.emmanuelneri.vendas.model;


import br.com.emmanuelneri.integrador.autenticacao.UsuarioGenerico;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
public class Usuario extends UsuarioGenerico {

    @ManyToMany
    @JoinTable(name="usuario_modulo",
            joinColumns= @JoinColumn(name="id_usuario", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_modulo", referencedColumnName="id"))
    @OrderBy(value = "id")
    private List<Modulo> modulos = new ArrayList<>();

    protected Usuario() {
    }

    public Usuario(Map<String, Object> tokenMap) {
       super(tokenMap);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public long getVersion() {
        return version;
    }

    public Set<String> getRoles() {
        return new HashSet<>();
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public List<Modulo> getModulosMenu() {
        List<Modulo> modulosMenu = modulos;
        modulosMenu.remove(Modulo.VENDAS);
        return modulos;
    }
}
