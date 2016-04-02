package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class IntegracaoVeiculoService {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Asynchronous
    public void enviarVeiculo(Veiculo veiculo) {
        enviar(clientVendasWS, veiculo);
        enviar(clienteRelatorioWS, veiculo);
    }

    private void enviar(WebTarget client, Veiculo veiculo) {
        client.path("/cadastros/veiculos/atualizar").queryParam("veiculo", veiculo.toVo())
                .request().put(Entity.entity(veiculo.toVo(), MediaType.APPLICATION_JSON));
    }
}
