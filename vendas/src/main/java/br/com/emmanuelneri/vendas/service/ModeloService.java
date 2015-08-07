package br.com.emmanuelneri.vendas.service;


import br.com.emmanuelneri.vendas.util.GenericWsService;
import br.com.emmanuelneri.vendas.vo.MarcaVo;
import br.com.emmanuelneri.vendas.vo.ModeloVo;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Named
public class ModeloService extends GenericWsService<ModeloVo> {

    public Map<MarcaVo, Collection<ModeloVo>> findModelosPorMarca() {
        return Multimaps.index(findAll(), ModeloVo::getMarca).asMap();
    }

    private List<ModeloVo> findAll() {
        return getList("/modelo/buscar/todos");
    }
}
