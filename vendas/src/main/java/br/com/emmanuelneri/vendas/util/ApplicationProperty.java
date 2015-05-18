package br.com.emmanuelneri.vendas.util;

import org.apache.deltaspike.core.api.config.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationProperty {

    @Inject
    @ConfigProperty(name = "nome.projeto")
    private String nomeProjeto;

    @Inject
    @ConfigProperty(name = "chave.aplicao")
    private String chaveAplicacao;

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }
}