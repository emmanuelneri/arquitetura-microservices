package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.util.GenericWsService;
import br.com.emmanuelneri.vendas.vo.ModeloVo;
import br.com.emmanuelneri.vendas.vo.VeiculoVo;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Named
public class VeiculoService extends GenericWsService<VeiculoVo> {

    public Map<ModeloVo, Collection<VeiculoVo>> findVeiculosPorModelo() {
        return Multimaps.index(findAll(), VeiculoVo::getModelo).asMap();
    }

    private List<VeiculoVo> findAll() {
        return getList("/veiculo/buscar/todos");
    }

    public VeiculoVo findById(Long id) {
        return get("/veiculo/buscar/" + id);
    }

}
