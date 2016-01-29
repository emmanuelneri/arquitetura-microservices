package br.com.emmanuelneri.cadastros.controller;

import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.cadastros.service.ClienteService;
import br.com.emmanuelneri.cadastros.util.AbstractCrudController;
import br.com.emmanuelneri.integrador.service.GenericService;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "cadastro-cliente", pattern = "/cadastros/cliente/", viewId = "/pages/cadastros/cadastro-cliente.xhtml")
})
public class ClienteController extends AbstractCrudController<Cliente> {

    private Cliente objeto;

    @Inject
    private ClienteService clienteService;

    @PostConstruct
    public void init() {
        inicializarObjeto();
        buscar();
    }

    @Override
    protected GenericService getService() {
        return clienteService;
    }

    @Override
    protected String getNomeCadastro() {
        return "Cliente";
    }

    @Override
    protected void inicializarObjeto() {
        this.objeto = new Cliente();
    }

    @Override
    public Cliente getObjeto() {
        return objeto;
    }

    @Override
    public Cliente setObjeto(Cliente cliente) {
        return objeto = cliente;
    }

}
