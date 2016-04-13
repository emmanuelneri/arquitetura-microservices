package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.relatorios.model.Modelo;
import br.com.emmanuelneri.relatorios.model.Veiculo;
import com.google.common.base.Strings;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    private ModeloService modeloService;

    @Transactional
    public Veiculo save(VeiculoVo veiculoVo) {
        Veiculo veiculo = findVeiculoOuCriaNovo(veiculoVo);
        save(veiculo);
        return veiculo;
    }

    private Veiculo findVeiculoOuCriaNovo(VeiculoVo veiculoVo) {
        Veiculo veiculo = findById(veiculoVo.getId());

        if (veiculo == null) {
            veiculo = new Veiculo();
            veiculo.setId(veiculoVo.getId());
        }

        if(!Strings.isNullOrEmpty(veiculoVo.getNome())) {
            veiculo.setNome(veiculoVo.getNome());
        }

        if(veiculoVo.getModelo() != null) {
            final Modelo modelo = modeloService.save(veiculoVo.getModelo());
            veiculo.setModelo(modelo);
        }

        return veiculo;
    }
}
