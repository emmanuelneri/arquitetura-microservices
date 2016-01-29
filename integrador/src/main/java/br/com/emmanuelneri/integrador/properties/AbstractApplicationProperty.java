package br.com.emmanuelneri.integrador.properties;

import org.apache.deltaspike.core.api.config.ConfigProperty;

import javax.inject.Inject;
import java.io.Serializable;

public abstract class AbstractApplicationProperty implements Serializable {

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

    public String getWsVendasEmail() {
        return wsVendasEmail;
    }

    public String getWsVendasSenha() {
        return wsVendasSenha;
    }

    public String getWsVendasUrl() {
        return wsVendasUrl;
    }

    public String getWsCadastrolUrl() {
        return wsCadastrolUrl;
    }

    public void setWsCadastrolUrl(String wsCadastrolUrl) {
        this.wsCadastrolUrl = wsCadastrolUrl;
    }

    public String getWsCadastroEmail() {
        return wsCadastroEmail;
    }

    public void setWsCadastroEmail(String wsCadastroEmail) {
        this.wsCadastroEmail = wsCadastroEmail;
    }

    public String getWsCadastroSenha() {
        return wsCadastroSenha;
    }

    public void setWsCadastroSenha(String wsCadastroSenha) {
        this.wsCadastroSenha = wsCadastroSenha;
    }
}