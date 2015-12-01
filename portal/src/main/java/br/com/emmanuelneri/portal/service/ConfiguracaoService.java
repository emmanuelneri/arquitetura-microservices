package br.com.emmanuelneri.portal.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.portal.model.Configuracao;

import javax.inject.Named;

@Named
public class ConfiguracaoService extends GenericService<Configuracao, Long> {

    public Configuracao findConfiguracao() {
        return findById(1L);
    }

}
