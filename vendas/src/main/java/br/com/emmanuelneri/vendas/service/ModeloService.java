package br.com.emmanuelneri.vendas.service;


import br.com.emmanuelneri.integrador.enuns.Marca;
import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import br.com.emmanuelneri.vendas.model.Modelo;
import com.google.common.collect.Multimaps;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    public Map<Marca, Collection<Modelo>> findModelosPorMarca() {
        return Multimaps.index(findAll(), Modelo::getMarca).asMap();
    }

    @Transactional
    public Modelo save(ModeloVo modeloVo) {
        Modelo modelo = findModeloOuCriaNovo(modeloVo);
        save(modelo);
        return modelo;
    }

    private Modelo findModeloOuCriaNovo(ModeloVo modeloVo) {
        Modelo modelo = findById(modeloVo.getId());

        if (modelo == null) {
            modelo = new Modelo();
            modelo.setId(modeloVo.getId());
        }

        modelo.setNome(modeloVo.getNome());
        modelo.setMarca(modeloVo.getMarca());

        return modelo;
    }

}
