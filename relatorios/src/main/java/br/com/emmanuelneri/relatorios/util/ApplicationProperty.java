package br.com.emmanuelneri.relatorios.util;

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

    @Inject
    @ConfigProperty(name = "ws.portal.url")
    private String wsPortalUrl;

    @Inject
    @ConfigProperty(name = "ws.portal.email")
    private String wsPortalEmail;

    @Inject
    @ConfigProperty(name = "ws.portal.senha")
    private String wsPortalSenha;

    @Inject
    @ConfigProperty(name = "ws.vendas.url")
    private String wsVendasUrl;

    @Inject
    @ConfigProperty(name = "ws.vendas.email")
    private String wsVendasEmail;

    @Inject
    @ConfigProperty(name = "ws.vendas.senha")
    private String wsVendasSenha;

    @Inject
    @ConfigProperty(name = "ws.cadastro.url")
    private String wsCadastrolUrl;

    @Inject
    @ConfigProperty(name = "ws.cadastro.email")
    private String wsCadastroEmail;

    @Inject
    @ConfigProperty(name = "ws.cadastro.senha")
    private String wsCadastroSenha;

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getChaveAplicacao() {
        return chaveAplicacao;
    }

    public String getWsPortalUrl() {
        return wsPortalUrl;
    }

    public String getWsPortalEmail() {
        return wsPortalEmail;
    }

    public String getWsPortalSenha() {
        return wsPortalSenha;
    }

    public String getWsVendasUrl() {
        return wsVendasUrl;
    }

    public String getWsVendasEmail() {
        return wsVendasEmail;
    }

    public String getWsVendasSenha() {
        return wsVendasSenha;
    }

    public String getWsCadastrolUrl() {
        return wsCadastrolUrl;
    }

    public String getWsCadastroEmail() {
        return wsCadastroEmail;
    }

    public String getWsCadastroSenha() {
        return wsCadastroSenha;
    }
}