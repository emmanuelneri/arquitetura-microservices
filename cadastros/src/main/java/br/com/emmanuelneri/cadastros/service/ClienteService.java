package br.com.emmanuelneri.cadastros.service;


import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.cadastros.util.GenericService;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;

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

    @Override
    protected void atualizarModulo(Cliente cliente) {
        clientVendasWS.path("/cadastros/clientes/atualizar").queryParam("cliente", cliente)
                .request().put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }
}
