package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import br.com.emmanuelneri.relatorios.model.Modelo;

import javax.inject.Named;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    public Modelo findModeloOuCriaNovo(ModeloVo modeloVo) {
        Modelo modelo = findById(modeloVo.getId());

        if (modelo == null) {
            modelo = new Modelo();
            modelo.setId(modeloVo.getId());
            modelo.setNome(modeloVo.getNome());
            modelo.setMarca(modeloVo.getMarca());
            getEntityManager().persist(modelo);
        }

        return modelo;

    }

}
