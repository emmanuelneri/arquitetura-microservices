package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericWsService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;

import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named
public class VeiculoService extends GenericWsService<VeiculoVo> {

    public Map<Long, VeiculoVo> findVeiculosPorId() {
        return findVeiculos().stream().collect(Collectors.toMap(VeiculoVo::getId, Function.identity()));
    }

    public List<VeiculoVo> findVeiculos() {
        return getList("/veiculo/buscar/todos");
    }
}
