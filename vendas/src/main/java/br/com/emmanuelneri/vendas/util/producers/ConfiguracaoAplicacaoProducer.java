package br.com.emmanuelneri.vendas.util.producers;


import br.com.emmanuelneri.vendas.model.Configuracao;
import br.com.emmanuelneri.vendas.service.ConfiguracaoService;
import br.com.emmanuelneri.vendas.util.anotations.ConfiguracaoAplicacao;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public final class ConfiguracaoAplicacaoProducer {

    @Inject
    private ConfiguracaoService configuracaoService;

    @Produces
    @ConfiguracaoAplicacao
    public Configuracao getConfiguracaoAplicacao() {
        return configuracaoService.getConfiguracao();
    }

}
