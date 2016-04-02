package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.relatorios.model.Cliente;

import javax.inject.Named;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    public Cliente findClienteOuCriaNovo(ClienteVo clienteVo) {
        Cliente cliente = findById(clienteVo.getId());

        if (cliente == null) {
            cliente = new Cliente();
            cliente.setId(clienteVo.getId());
            cliente.setNome(clienteVo.getNome());
            cliente.setCpfCnpj(clienteVo.getCpfCnpj());
            getEntityManager().persist(cliente);
        }

        return cliente;
    }

}
