package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.integrador.service.GenericService;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.vendas.model.Modelo;
import br.com.emmanuelneri.vendas.model.Veiculo;
import com.google.common.collect.Multimaps;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;

@Named
public class VeiculoService extends GenericService<Veiculo, Long> {

    @Inject
    private ModeloService modeloService;

    public Map<Modelo, Collection<Veiculo>> findVeiculosPorModelo() {
        return Multimaps.index(findAll(), Veiculo::getModelo).asMap();
    }

    @Transactional
    public void save(VeiculoVo veiculoVo) {
        Veiculo veiculo = findVeiculoOuCriaNovo(veiculoVo);
        save(veiculo);
    }

    public Veiculo findVeiculoOuCriaNovo(VeiculoVo veiculoVo) {
        Veiculo veiculo = findById(veiculoVo.getId());

        if (veiculo == null) {
            veiculo = new Veiculo();
            veiculo.setId(veiculoVo.getId());
        }

        veiculo.setNome(veiculoVo.getNome());

        final Modelo modelo = modeloService.save(veiculoVo.getModelo());
        veiculo.setModelo(modelo);

        return veiculo;
    }

}
