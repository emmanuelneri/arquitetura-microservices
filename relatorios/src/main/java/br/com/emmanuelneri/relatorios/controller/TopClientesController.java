package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.integrador.vo.ClienteRankingVo;
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
        @URLMapping(id = "top-clientes", pattern = "/relatorios/clientes/top/", viewId = "/pages/relatorios/top-clientes.xhtml")
})
public class TopClientesController implements Serializable {

    private List<ClienteRankingVo> clientes;

    @Inject
    private ConsultaWsPedidoService consultaWsPedidoService;

    @URLAction(mappingId = "top-clientes", onPostback = false)
    public void init() {
        clientes = consultaWsPedidoService.findTopClientes();
    }

    public List<ClienteRankingVo> getClientes() {
        return clientes;
    }
}
