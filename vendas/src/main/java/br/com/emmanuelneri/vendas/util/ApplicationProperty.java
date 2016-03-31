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
    @ConfigProperty(name = "ws.relatorios.url")
    private String wsRelatoriosUrl;

    @Inject
    @ConfigProperty(name = "ws.relatorios.email")
    private String wsRelatoriosEmail;

    @Inject
    @ConfigProperty(name = "ws.relatorios.senha")
    private String wsRelatoriosSenha;

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

    public String getWsRelatoriosUrl() {
        return wsRelatoriosUrl;
    }

    public String getWsRelatoriosEmail() {
        return wsRelatoriosEmail;
    }

    public String getWsRelatoriosSenha() {
        return wsRelatoriosSenha;
    }
}