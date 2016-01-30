package br.com.emmanuelneri.cadastros.service;

import br.com.emmanuelneri.portal.model.Modelo;
import br.com.emmanuelneri.portal.model.enuns.Marca;
import br.com.emmanuelneri.portal.util.GenericService;
import com.google.common.collect.Multimaps;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Map;

@Stateless
public class ModeloService extends GenericService<Modelo, Long> {

    public Map<Marca, Collection<Modelo>> findModelosPorMarca() {
        return Multimaps.index(findAll(), Modelo::getMarca).asMap();
    }

}
