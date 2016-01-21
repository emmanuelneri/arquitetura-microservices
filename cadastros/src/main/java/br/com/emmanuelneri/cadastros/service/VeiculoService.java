package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.cadastros.model.Veiculo;
import br.com.emmanuelneri.cadastros.util.GenericService;
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
