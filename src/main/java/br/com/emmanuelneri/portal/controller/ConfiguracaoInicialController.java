package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.ConfiguracaoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class ConfiguracaoInicialController implements Serializable {

    private Configuracao configuracao;

    @Inject
    private ConfiguracaoService configuracaoService;

    @PostConstruct
    public void init() {
        this.configuracao = new Configuracao();
    }

    public String salvar() {
        this.configuracaoService.save(configuracao);
        return "index";
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }
}
