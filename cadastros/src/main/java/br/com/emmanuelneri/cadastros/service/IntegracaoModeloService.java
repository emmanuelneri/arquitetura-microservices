package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class IntegracaoModeloService {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Asynchronous
    public void enviarModulo(Modelo modelo) {
        enviar(clientVendasWS, modelo);
        enviar(clienteRelatorioWS, modelo);
    }

    private void enviar(WebTarget client, Modelo modelo) {
        client.path("/cadastros/modelos/atualizar").queryParam("modelo", modelo.toVo())
                .request().put(Entity.entity(modelo.toVo(), MediaType.APPLICATION_JSON));
    }
}
