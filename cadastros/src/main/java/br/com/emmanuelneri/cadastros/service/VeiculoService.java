package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.integrador.service.GenericService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    private IntegracaoVeiculoService veiculoService;

    @Override
    protected void atualizarModulo(Veiculo veiculo) {
        veiculoService.enviarVeiculo(veiculo);
    }

}
