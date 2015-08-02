package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.vo.ModeloVo;
import br.com.emmanuelneri.vendas.vo.VeiculoVo;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Named
public class VeiculoService implements Serializable {

    public Map<ModeloVo, Collection<VeiculoVo>> findVeiculosPorModelo() {
        return Multimaps.index(findAll(), VeiculoVo::getModelo).asMap();
    }

    private List<VeiculoVo> findAll() {
        return new ArrayList<>();
    }

}
