package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.integrador.service.GenericWsService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;

import javax.inject.Named;
import java.util.List;

@Named
public class ClienteService extends GenericWsService<ClienteVo> {

    public List<ClienteVo> findAll() {
        return getList("/cliente/buscar/todos");
    }

    public ClienteVo findById(Long id) {
        return get("/cliente/buscar/" + id);
    }

}
