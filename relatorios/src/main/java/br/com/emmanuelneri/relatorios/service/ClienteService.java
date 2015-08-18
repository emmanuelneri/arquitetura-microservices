package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.relatorios.util.GenericWsService;
import br.com.emmanuelneri.relatorios.vo.ClienteVo;

import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named
public class ClienteService extends GenericWsService<ClienteVo> {

    public Map<Long, ClienteVo> findClientesPorId() {
        return findClientes().stream().collect(Collectors.toMap(ClienteVo::getId, Function.identity()));
    }

    public List<ClienteVo> findClientes() {
        return getList("/cliente/buscar/todos");
    }
}
