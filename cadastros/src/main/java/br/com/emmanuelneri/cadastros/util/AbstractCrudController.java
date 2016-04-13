package br.com.emmanuelneri.cadastros.util;

import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.integrador.service.GenericService;
import org.omnifaces.util.Messages;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudController<T extends Model> implements Serializable {

    private List<T> lista;

    protected abstract GenericService getService();
    protected abstract String getNomeCadastro();
    protected abstract void inicializarObjeto();
    public abstract T getObjeto();
    public abstract T setObjeto(T t);

    @SuppressWarnings("unchecked")
    public void salvar() {
        long start = System.currentTimeMillis();
        getService().salvarEAtulizarModulo(getObjeto());
        buscar();
        inicializarObjeto();
        Messages.addInfo(null, getNomeCadastro() + " salvo com sucesso!");
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("--------------");
    }

    @SuppressWarnings("unchecked")
    public void excluir(T t) {
        getService().delete(t);
        buscar();
        inicializarObjeto();
        Messages.addInfo(null, getNomeCadastro() + " excluido com sucesso!");
    }

    @SuppressWarnings("unchecked")
    public void editar(T t) {
        setObjeto(t);
    }

    @SuppressWarnings("unchecked")
    public void buscar() {
       lista = getService().findAll();
    }

    public List<T> getLista() {
        return lista;
    }

}
