package br.com.emmanuelneri.relatorios.controller;

import br.com.emmanuelneri.vendas.service.PedidoService;
import br.com.emmanuelneri.vendas.vo.ClienteRankingVo;
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
    private PedidoService pedidoService;

    @URLAction(mappingId = "top-clientes", onPostback = false)
    public void init() {
        clientes = pedidoService.findTopClientes();
    }

    public List<ClienteRankingVo> getClientes() {
        return clientes;
    }
}
