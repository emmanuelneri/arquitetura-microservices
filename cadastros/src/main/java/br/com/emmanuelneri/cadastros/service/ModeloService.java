package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.cadastros.util.GenericService;
import br.com.emmanuelneri.cadastros.util.anotations.VendasClientWS;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    @Inject
    @VendasClientWS
    private WebTarget clientVendasWS;

    @Override
    protected void atualizarModulo(Modelo modelo) {
        clientVendasWS.path("/cadastros/modelos/atualizar").queryParam("modelo", modelo)
                .request().put(Entity.entity(modelo, MediaType.APPLICATION_JSON));
    }

}
