package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.cadastros.model.Modelo;
import br.com.emmanuelneri.cadastros.model.enuns.Marca;
import br.com.emmanuelneri.cadastros.util.GenericService;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    public Map<Marca, Collection<Modelo>> findModelosPorMarca() {
        return Multimaps.index(findAll(), Modelo::getMarca).asMap();
    }

}
