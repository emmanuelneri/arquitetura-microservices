package br.com.emmanuelneri.vendas.model;

import br.com.emmanuelneri.menu.model.ConfiguracaoMenu;
import br.com.emmanuelneri.menu.model.ModuloMenu;
import br.com.emmanuelneri.vendas.util.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Configuracao implements Model<Long>, ConfiguracaoMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100, name = "nome_cliente")
    private String nomeCliente;

    @NotNull
    @Column(length = 32, name = "chave_aplicacao")
    private String chaveAplicacao;

    @Override
    public Long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public List<ModuloMenu> getModulosMenu() {
        return null;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }
}
