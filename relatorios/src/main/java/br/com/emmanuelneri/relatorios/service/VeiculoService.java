package br.com.emmanuelneri.relatorios.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.relatorios.model.Modelo;
import br.com.emmanuelneri.relatorios.model.Veiculo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    private ModeloService modeloService;

    @Transactional
    public void save(VeiculoVo veiculoVo) {
        Veiculo veiculo = getVeiculoByVo(veiculoVo);
        save(veiculo);
    }

    public Veiculo findVeiculoOuCriaNovo(VeiculoVo veiculoVo) {
        Veiculo veiculo = findById(veiculoVo.getId());

        if (veiculo == null) {
            veiculo = getVeiculoByVo(veiculoVo);

            getEntityManager().persist(veiculo);
        }

        return veiculo;
    }

    private Veiculo getVeiculoByVo(VeiculoVo veiculoVo) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(veiculoVo.getId());
        veiculo.setNome(veiculoVo.getNome());

        final Modelo modelo = modeloService.findModeloOuCriaNovo(veiculoVo.getModelo());
        veiculo.setModelo(modelo);
        return veiculo;
    }

}
