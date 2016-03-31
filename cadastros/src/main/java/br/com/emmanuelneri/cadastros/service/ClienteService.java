package br.com.emmanuelneri.cadastros.service;


import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;
import br.com.emmanuelneri.integrador.service.GenericService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Inject
    @RelatoriosClientWS
    private WebTarget clienteRelatorioWS;

    @Override
    protected void atualizarModulo(Cliente cliente) {
        enviarCliente(clientVendasWS, cliente);
        enviarCliente(clienteRelatorioWS, cliente);
    }

    private void enviarCliente(WebTarget client, Cliente cliente) {
        client.path("/cadastros/clientes/atualizar").queryParam("cliente", cliente)
                .request().put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }
}
