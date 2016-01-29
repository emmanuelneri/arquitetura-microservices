package br.com.emmanuelneri.vendas.util.producers;


import br.com.emmanuelneri.integrador.anotations.CadastroClientWs;
import br.com.emmanuelneri.integrador.anotations.PortalClientWs;
import br.com.emmanuelneri.vendas.util.ApplicationProperty;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public final class ClientWsProducer {

    @Inject
    private ApplicationProperty configuracao;

    @Named("portalClientWs")
    @Produces
    @PortalClientWs
    public WebTarget getWebTarget() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsPortalUrl())
                .queryParam("email", configuracao.getWsPortalEmail())
                .queryParam("senha", configuracao.getWsPortalSenha());
    }

    @Named("cadastroClientWs")
    @Produces
    @CadastroClientWs
    public WebTarget getClientCadastros() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsCadastrolUrl())
                .queryParam("email", configuracao.getWsCadastroEmail())
                .queryParam("senha", configuracao.getWsCadastroSenha());
    }

}
