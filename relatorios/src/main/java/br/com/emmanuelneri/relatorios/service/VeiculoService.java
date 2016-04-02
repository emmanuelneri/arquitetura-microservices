package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.relatorios.model.Modelo;
import br.com.emmanuelneri.relatorios.model.Veiculo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    private ModeloService modeloService;

    public Veiculo findVeiculoOuCriaNovo(VeiculoVo veiculoVo) {
        Veiculo veiculo = findById(veiculoVo.getId());

        if (veiculo == null) {
            veiculo = new Veiculo();
            veiculo.setId(veiculoVo.getId());
            veiculo.setNome(veiculoVo.getNome());

            final Modelo modelo = modeloService.findModeloOuCriaNovo(veiculoVo.getModelo());
            veiculo.setModelo(modelo);

            getEntityManager().persist(veiculo);
        }

        return veiculo;
    }

}
