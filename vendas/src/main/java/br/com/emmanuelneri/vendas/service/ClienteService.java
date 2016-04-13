package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.vendas.model.Cliente;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    @Transactional
    public void save(ClienteVo clienteVo) {
        Cliente cliente = findClienteOuCriaNovo(clienteVo);
        save(cliente);
    }

    private Cliente findClienteOuCriaNovo(ClienteVo clienteVo) {
        Cliente cliente = findById(clienteVo.getId());

        if (cliente == null) {
            cliente = new Cliente();
            cliente.setId(clienteVo.getId());
        }

        cliente.setNome(clienteVo.getNome());
        cliente.setCpfCnpj(clienteVo.getCpfCnpj());

        return cliente;
    }
}
