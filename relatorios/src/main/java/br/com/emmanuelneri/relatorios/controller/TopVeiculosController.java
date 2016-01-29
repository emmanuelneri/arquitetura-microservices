package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.integrador.vo.VeiculoRankingVo;
import br.com.emmanuelneri.relatorios.service.ConsultaWsPedidoService;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "top-veiculos", pattern = "/relatorios/veiculos/top/", viewId = "/pages/relatorios/top-veiculos.xhtml")
})
public class TopVeiculosController implements Serializable {

    private List<VeiculoRankingVo> veiculos;

    @Inject
    private ConsultaWsPedidoService consultaWsPedidoService;

    @URLAction(mappingId = "top-veiculos", onPostback = false)
    public void init() {
        veiculos = consultaWsPedidoService.findTopVeiculos();
    }

    public List<VeiculoRankingVo> getVeiculos() {
        return veiculos;
    }
}
