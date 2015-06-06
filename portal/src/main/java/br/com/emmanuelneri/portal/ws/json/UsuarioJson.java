package br.com.emmanuelneri.portal.ws.json;

import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Usuario;

import java.util.List;

public final class UsuarioJson {

    private Long id;

    private long version;

    private String email;

    private String nome;

    private List<Modulo> modulos;

    public UsuarioJson(Usuario usuario) {
        this.id = usuario.getId();
        this.version = usuario.getVersion();
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
        this.modulos = usuario.getModulos();
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }
}
