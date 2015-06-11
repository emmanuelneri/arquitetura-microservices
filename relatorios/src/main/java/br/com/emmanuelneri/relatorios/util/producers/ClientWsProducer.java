package br.com.emmanuelneri.relatorios.util.producers;


import br.com.emmanuelneri.relatorios.util.ApplicationProperty;
import br.com.emmanuelneri.relatorios.util.anotations.ClientWs;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public final class ClientWsProducer {

    @Inject
    private ApplicationProperty configuracao;

    @Named("clientWs")
    @Produces
    @ClientWs
    public WebTarget getWebTarget() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsPortalUrl())
                .queryParam("email", configuracao.getWsPortalEmail())
                .queryParam("senha", configuracao.getWsPortalSenha());
    }

}
