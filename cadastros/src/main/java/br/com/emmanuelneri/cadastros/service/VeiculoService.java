package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;
import br.com.emmanuelneri.integrador.service.GenericService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Override
    protected void atualizarModulo(Veiculo veiculo) {
        enviarVeiculo(clientVendasWS, veiculo);
        enviarVeiculo(clienteRelatorioWS, veiculo);
    }

    private void enviarVeiculo(WebTarget client, Veiculo veiculo) {
        client.path("/cadastros/veiculos/atualizar").queryParam("veiculo", veiculo)
                .request().put(Entity.entity(veiculo, MediaType.APPLICATION_JSON));
    }
}
