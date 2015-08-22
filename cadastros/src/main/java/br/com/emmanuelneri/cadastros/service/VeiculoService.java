package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.cadastros.util.GenericService;
import br.com.emmanuelneri.anotations.VendasClientWS;

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

    @Override
    protected void atualizarModulo(Veiculo veiculo) {
        clientVendasWS.path("/cadastros/veiculos/atualizar").queryParam("veiculo", veiculo)
                .request().put(Entity.entity(veiculo, MediaType.APPLICATION_JSON));
    }
}
