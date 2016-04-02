package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class IntegracaoClienteService {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Asynchronous
    public void enviarCliente(Cliente cliente) {
        enviar(clientVendasWS, cliente);
        enviar(clienteRelatorioWS, cliente);
    }

    private void enviar(WebTarget client, Cliente cliente) {
        client.path("/cadastros/clientes/atualizar").queryParam("cliente", cliente)
                .request().put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }

}
