package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.relatorios.model.Cliente;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ClienteService extends GenericService<Cliente, Long> {

    @Transactional
    public void save(ClienteVo clienteVo) {
        Cliente cliente = getClienteByVo(clienteVo);
        save(cliente);
    }

    public Cliente findClienteOuCriaNovo(ClienteVo clienteVo) {
        Cliente cliente = findById(clienteVo.getId());

        if (cliente == null) {
            cliente = getClienteByVo(clienteVo);
            getEntityManager().persist(cliente);
        }

        return cliente;
    }

    private Cliente getClienteByVo(ClienteVo clienteVo) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteVo.getId());
        cliente.setNome(clienteVo.getNome());
        cliente.setCpfCnpj(clienteVo.getCpfCnpj());
        return cliente;
    }

}
