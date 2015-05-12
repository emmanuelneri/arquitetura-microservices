package br.com.emmanuelneri.autenticacao;


import br.com.emmanuelneri.menu.model.UsuarioMenu;
import br.com.emmanuelneri.vendas.util.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Usuario implements Model<Long>, UsuarioMenu {

    @Id
    private Long id;

    @Version
    private long version;

    @NotNull
    private String email;

    @NotNull
    private String nome;

    protected Usuario() {
    }

    public Usuario(Map<String, Object> tokenMap) {
        this.id = Long.valueOf((Integer) tokenMap.get("id"));
        this.email = (String) tokenMap.get("email");
        this.nome = (String) tokenMap.get("nome");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public long getVersion() {
        return version;
    }

    public Set<String> getRoles() {
        return new HashSet<>();
    }
}
