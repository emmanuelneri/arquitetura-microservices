package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.integrador.service.GenericService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    @Inject
    private IntegracaoModeloService integracaoModeloService;

    @Override
    protected void atualizarModulo(Modelo modelo) {
        integracaoModeloService.enviarModulo(modelo);
    }

}
