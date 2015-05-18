package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.util.GenericService;

import javax.inject.Named;

@Named
public class ConfiguracaoService extends GenericService<Configuracao> {

    public Configuracao getConfiguracao() {
        return findById(1L);
    }

}
