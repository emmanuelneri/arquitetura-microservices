package br.com.emmanuelneri.cadastros.service;


import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.integrador.service.GenericService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    @Inject
    private IntegracaoClienteService integracaoClienteService;

    @Override
    public void atualizarModulo(Cliente cliente) {
        integracaoClienteService.enviarCliente(cliente);
    }


}
