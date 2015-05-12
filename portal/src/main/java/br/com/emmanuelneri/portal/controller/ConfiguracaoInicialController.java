package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Modulo;
import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.ModuloService;
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
    private List<Modulo> modulos;

    @Inject
    private ConfiguracaoService configuracaoService;

    @Inject
    private ModuloService moduloService;

    @PostConstruct
    public void init() {
        this.configuracao = new Configuracao();
        this.modulos = this.moduloService.findAll();
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

    public List<Modulo> getModulos() {
        return modulos;
    }
}
