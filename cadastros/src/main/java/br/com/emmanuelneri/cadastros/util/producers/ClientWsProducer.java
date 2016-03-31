package br.com.emmanuelneri.cadastros.util.producers;


import br.com.emmanuelneri.cadastros.util.ApplicationProperty;
import br.com.emmanuelneri.integrador.anotations.PortalClientWS;
import br.com.emmanuelneri.integrador.anotations.RelatoriosClientWS;
import br.com.emmanuelneri.integrador.anotations.VendasClientWS;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public final class ClientWsProducer {

    @Inject
    private ApplicationProperty configuracao;

    @Named("portalClientWS")
    @Produces
    @PortalClientWS
    public WebTarget getClientPortal() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsPortalUrl())
                .queryParam("email", configuracao.getWsPortalEmail())
                .queryParam("senha", configuracao.getWsPortalSenha());
    }

    @Named("vendasClientWS")
    @Produces
    @VendasClientWS
    public WebTarget getClientVendas() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsVendasUrl())
                .queryParam("email", configuracao.getWsVendasEmail())
                .queryParam("senha", configuracao.getWsVendasSenha());
    }

    @Named("relatoriosClientWS")
    @Produces
    @RelatoriosClientWS
    public WebTarget getClientRelatorios() {
        final Client client = ClientBuilder.newClient();
        return client.target(configuracao.getWsRelatoriosUrl())
                .queryParam("email", configuracao.getWsRelatoriosEmail())
                .queryParam("senha", configuracao.getWsRelatoriosSenha());
    }

}
