package br.com.emmanuelneri.vendas.model;


import br.com.emmanuelneri.vendas.util.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u left join fetch u.modulos m where u.email = :email")
})
public class Usuario implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private long version;

    @NotNull
    private String email;

    @NotNull
    private String nome;

    @ManyToMany
    @JoinTable(name="usuario_modulo",
            joinColumns= @JoinColumn(name="id_usuario", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_modulo", referencedColumnName="id"))
    @OrderBy(value = "id")
    private List<Modulo> modulos = new ArrayList<>();

    protected Usuario() {
    }

    public Usuario(Map<String, Object> tokenMap) {
        this.id = Long.valueOf((Integer) tokenMap.get("id"));
        this.email = (String) tokenMap.get("email");
        this.nome = (String) tokenMap.get("nome");
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
