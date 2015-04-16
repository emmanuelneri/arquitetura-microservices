package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.menu.model.ConfiguracaoMenu;
import br.com.emmanuelneri.menu.model.ModuloMenu;
import br.com.emmanuelneri.portal.util.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Configuracao implements Model<Long>, ConfiguracaoMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100, name = "nome_projeto")
    private String nomeProjeto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="configuracao_modulo",
            joinColumns={@JoinColumn(name="id_configuracao")},
            inverseJoinColumns={@JoinColumn(name="id_modulo")})
    private List<Modulo> modulos = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    @Override
    public List<ModuloMenu> getModulosMenu() {
        return new ArrayList<>(modulos);
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String getNomeCliente() {
        return nomeProjeto;
    }
}
