package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import br.com.emmanuelneri.relatorios.model.Modelo;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

    @Transactional
    public void save(ModeloVo modeloVo) {
        Modelo modelo = getModeloByVo(modeloVo);
        save(modelo);
    }

    public Modelo findModeloOuCriaNovo(ModeloVo modeloVo) {
        Modelo modelo = findById(modeloVo.getId());

        if (modelo == null) {
            modelo = getModeloByVo(modeloVo);
            getEntityManager().persist(modelo);
        }

        return modelo;
    }

    private Modelo getModeloByVo(ModeloVo modeloVo) {
        Modelo modelo = new Modelo();
        modelo.setId(modeloVo.getId());
        modelo.setNome(modeloVo.getNome());
        modelo.setMarca(modeloVo.getMarca());
        return modelo;
    }
}
