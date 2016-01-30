package br.com.emmanuelneri.cadastros.controller;

import br.com.emmanuelneri.cadastros.service.ModeloService;
import br.com.emmanuelneri.cadastros.service.VeiculoService;
import br.com.emmanuelneri.cadastros.util.AbstractCrudController;
import br.com.emmanuelneri.portal.model.Modelo;
import br.com.emmanuelneri.portal.model.Veiculo;
import br.com.emmanuelneri.portal.util.GenericService;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "cadastro-veiculo", pattern = "/cadastros/veiculo/", viewId = "/pages/cadastros/cadastro-veiculo.xhtml")
})
public class VeiculoController extends AbstractCrudController<Veiculo> {

    private Veiculo objeto;
    private List<Modelo> modelos;

    @Inject
    private VeiculoService veiculoService;

    @Inject
    private ModeloService modeloService;

    @PostConstruct
    public void init() {
        inicializarObjeto();
        buscar();

        this.modelos = modeloService.findAll();
    }

    @Override
    protected GenericService getService() {
        return veiculoService;
    }

    @Override
    protected String getNomeCadastro() {
        return "Veículo";
    }

    @Override
    protected void inicializarObjeto() {
        objeto = new Veiculo();
    }

    @Override
    public Veiculo getObjeto() {
        return objeto;
    }

    @Override
    public Veiculo setObjeto(Veiculo veiculo) {
        return objeto = veiculo;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }
}
