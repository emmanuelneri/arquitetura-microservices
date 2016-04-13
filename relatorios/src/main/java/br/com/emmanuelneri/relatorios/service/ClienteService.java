package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.relatorios.model.Cliente;
import com.google.common.base.Strings;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    @Transactional
    public Cliente save(ClienteVo clienteVo) {
        Cliente cliente = findClienteOuCriaNovo(clienteVo);
        save(cliente);
        return cliente;
    }

    private Cliente findClienteOuCriaNovo(ClienteVo clienteVo) {
        Cliente cliente = findById(clienteVo.getId());

        if (cliente == null) {
            cliente = new Cliente();
            cliente.setId(clienteVo.getId());
        }

        if(!Strings.isNullOrEmpty(clienteVo.getNome())) {
            cliente.setNome(clienteVo.getNome());
        }

        if(!Strings.isNullOrEmpty(clienteVo.getCpfCnpj())) {
            cliente.setCpfCnpj(clienteVo.getCpfCnpj());
        }

        return cliente;
    }
}
