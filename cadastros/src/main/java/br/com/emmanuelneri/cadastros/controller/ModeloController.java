package br.com.emmanuelneri.cadastros.controller;

import br.com.emmanuelneri.cadastros.service.ModeloService;
import br.com.emmanuelneri.cadastros.util.AbstractCrudController;
import br.com.emmanuelneri.portal.model.Modelo;
import br.com.emmanuelneri.portal.model.enuns.Marca;
import br.com.emmanuelneri.portal.util.GenericService;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "cadastro-modelo", pattern = "/cadastros/modelo/", viewId = "/pages/cadastros/cadastro-modelo.xhtml")
})
public class ModeloController extends AbstractCrudController<Modelo> {

    private Modelo objeto;
    private List<Marca> marcas;

    @Inject
    private ModeloService modeloService;

    @PostConstruct
    public void init() {
        inicializarObjeto();
        marcas = Arrays.asList(Marca.values());

        buscar();
    }

    @Override
    protected GenericService getService() {
        return modeloService;
    }

    @Override
    protected String getNomeCadastro() {
        return "Modelo";
    }

    @Override
    protected void inicializarObjeto() {
        this.objeto = new Modelo();
    }

    @Override
    public Modelo getObjeto() {
        return objeto;
    }

    @Override
    public Modelo setObjeto(Modelo modelo) {
        return this.objeto = modelo;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

}
