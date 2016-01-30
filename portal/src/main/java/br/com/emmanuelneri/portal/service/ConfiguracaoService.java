package br.com.emmanuelneri.portal.service;

import br.com.emmanuelneri.portal.model.Configuracao;
import br.com.emmanuelneri.portal.util.GenericService;

import javax.ejb.Stateless;

@Stateless
public class ConfiguracaoService extends GenericService<Configuracao, Long> {

    public Configuracao findConfiguracao() {
        return findById(1L);
    }

}
