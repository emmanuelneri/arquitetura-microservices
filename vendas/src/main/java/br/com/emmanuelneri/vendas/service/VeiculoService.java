package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.model.Modelo;
import br.com.emmanuelneri.vendas.model.Veiculo;
import br.com.emmanuelneri.vendas.util.GenericService;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    public Map<Modelo, Collection<Veiculo>> findVeiculosPorModelo() {
        return Multimaps.index(findAll(), Veiculo::getModelo).asMap();
    }

}
