package br.com.emmanuelneri.integrador.autenticacao;


import br.com.emmanuelneri.integrador.interfaces.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Map;

@MappedSuperclass
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "usuario_uk", columnNames ={"email"})
})
@NamedQueries(value = {
        @NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u where u.email = :email"),
        @NamedQuery(name = "Usuario.findCompletoByEmail", query = "select u from Usuario u left join fetch u.modulos m where u.email = :email"),
})
public abstract class UsuarioGenerico implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected long version;

    @NotNull
    protected String email;

    @NotNull
    protected String nome;

    protected UsuarioGenerico() {

    }

    public UsuarioGenerico(Map<String, Object> tokenMap) {
        this.id = Long.valueOf((Integer) tokenMap.get("id"));
        this.email = (String) tokenMap.get("email");
        this.nome = (String) tokenMap.get("nome");
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
