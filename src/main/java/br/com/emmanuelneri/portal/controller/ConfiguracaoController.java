package br.com.emmanuelneri.portal.controller;

import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.ConfiguracaoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@ApplicationScoped
public class ConfiguracaoController {

    private Configuracao configuracao;

    @Inject
    private ConfiguracaoService configuracaoService;

    @PostConstruct
    public void init() throws IOException {
        this.configuracao = configuracaoService.findConfiguracao();
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }
}
