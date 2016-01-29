package br.com.emmanuelneri.vendas.service;


import br.com.emmanuelneri.integrador.enuns.Marca;
import br.com.emmanuelneri.integrador.service.GenericWsService;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Named
public class ModeloService extends GenericWsService<ModeloVo> {

    public Map<Marca, Collection<ModeloVo>> findModelosPorMarca() {
        return Multimaps.index(findAll(), ModeloVo::getMarca).asMap();
    }

    private List<ModeloVo> findAll() {
        return getList("/modelo/buscar/todos");
    }
}
