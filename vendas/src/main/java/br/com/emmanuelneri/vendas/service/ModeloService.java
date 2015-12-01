package br.com.emmanuelneri.vendas.service;


import br.com.emmanuelneri.integrador.enuns.Marca;
import br.com.emmanuelneri.vendas.model.Modelo;
import br.com.emmanuelneri.vendas.util.GenericService;
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
