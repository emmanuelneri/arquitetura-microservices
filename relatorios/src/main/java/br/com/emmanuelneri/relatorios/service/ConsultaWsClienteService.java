package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericWsService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;

import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named
public class ConsultaWsClienteService extends GenericWsService<ClienteVo> {

    public Map<Long, ClienteVo> findClientesPorId() {
        return findClientes().stream().collect(Collectors.toMap(ClienteVo::getId, Function.identity()));
    }

    public List<ClienteVo> findClientes() {
        return getList("/cliente/buscar/todos");
    }
}
