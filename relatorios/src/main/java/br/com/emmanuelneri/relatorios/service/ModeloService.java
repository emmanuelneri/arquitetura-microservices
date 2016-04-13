package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import br.com.emmanuelneri.relatorios.model.Modelo;
import com.google.common.base.Strings;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ModeloService extends GenericService<Modelo, Long> {

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

        if(!Strings.isNullOrEmpty(modeloVo.getNome())) {
            modelo.setNome(modeloVo.getNome());
        }

        if(modeloVo.getMarca() != null) {
            modelo.setMarca(modeloVo.getMarca());
        }

        return modelo;
    }
}
