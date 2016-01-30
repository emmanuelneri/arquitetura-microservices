package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.portal.model.Modelo;
import br.com.emmanuelneri.portal.model.Veiculo;
import br.com.emmanuelneri.portal.util.GenericService;
import com.google.common.collect.Multimaps;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Map;

@Stateless
public class VeiculoService extends GenericService<Veiculo, Long> {

    public Map<Modelo, Collection<Veiculo>> findVeiculosPorModelo() {
        return Multimaps.index(findAll(), Veiculo::getModelo).asMap();
    }

}
