package br.com.emmanuelneri.portal.util.producers;


import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.service.ConfiguracaoService;
import br.com.emmanuelneri.portal.util.annotations.ConfiguracaoAplicacao;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public final class ConfiguracaoProducer {

    @Inject
    private ConfiguracaoService configuracaoService;

    @Named("configuracaoAplicacao")
    @Produces
    @ConfiguracaoAplicacao
    public Configuracao getConfiguracao() {
        return configuracaoService.findConfiguracao();
    }

}
