package br.com.emmanuelneri.portal.service;

import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.util.GenericService;

import javax.inject.Named;

@Named
public class ConfiguracaoService extends GenericService<Configuracao> {

    public Configuracao findConfiguracao() {
        return findById(1L);
    }

}
