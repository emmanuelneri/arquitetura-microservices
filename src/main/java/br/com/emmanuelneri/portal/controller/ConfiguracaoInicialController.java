package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Aplicacao;
import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.AplicacaoService;
import br.com.emmanuelneri.portal.service.ConfiguracaoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ConfiguracaoInicialController implements Serializable {

    private Configuracao configuracao;
    private List<Aplicacao> aplicacoes;

    @Inject
    private ConfiguracaoService configuracaoService;

    @Inject
    private AplicacaoService aplicacaoService;

    @PostConstruct
    public void init() {
        this.configuracao = new Configuracao();
        this.aplicacoes = this.aplicacaoService.findAll();
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

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }
}
