package br.com.emmanuelneri.vendas.controller;

import br.com.emmanuelneri.vendas.exception.ValidationException;
import br.com.emmanuelneri.vendas.model.Cliente;
import br.com.emmanuelneri.vendas.model.ItemPedido;
import br.com.emmanuelneri.vendas.model.Modelo;
import br.com.emmanuelneri.vendas.model.Pedido;
import br.com.emmanuelneri.vendas.model.Veiculo;
import br.com.emmanuelneri.vendas.model.enuns.Marca;
import br.com.emmanuelneri.vendas.service.ClienteService;
import br.com.emmanuelneri.vendas.service.ModeloService;
import br.com.emmanuelneri.vendas.service.PedidoService;
import br.com.emmanuelneri.vendas.service.VeiculoService;
import br.com.emmanuelneri.vendas.shiro.UsuarioVO;
import br.com.emmanuelneri.vendas.util.anotations.UsuarioLogado;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "cadastro-pedido", pattern = "/pedido/", viewId = "/pages/pedido/cadastro-pedido.xhtml"),
        @URLMapping(id = "editar-pedido", pattern = "/pedido/visualizar/#{pedidoController.idPedido}/", viewId = "/pages/pedido/cadastro-pedido.xhtml")
})
public class PedidoController implements Serializable {

    private List<Cliente> clientes;
    private List<Marca> marcas;
    private Map<Marca, Collection<Modelo>> modeloPorMarca;
    private Map<Modelo, Collection<Veiculo>> veiculosPorModelo;

    private Pedido pedido;
    private Marca marca;
    private Modelo modelo;
    private Veiculo veiculo;

    private BigDecimal valorUnitario;
    private int quantidade = 0;

    private Long idPedido;

    @Inject
    @UsuarioLogado
    private UsuarioVO usuario;

    @Inject
    private PedidoService pedidoService;

    @Inject
    private ClienteService clienteService;

    @Inject
    private ModeloService modeloService;

    @Inject
    private VeiculoService veiculoService;

    @PostConstruct
    public void init() {
        inicializarCombos();
    }

    @URLAction(mappingId = "cadastro-pedido", onPostback = false)
    public void initCadastro() {
        pedido = new Pedido(0L);
        inicializarItem();
    }

    @URLAction(mappingId = "editar-pedido", onPostback = false)
    public void initEditar() {
       pedido = pedidoService.findPedidoCompletoById(idPedido);
    }

    public void adicionarItem() {
        this.pedido.adicionarItem(valorUnitario, quantidade, veiculo);
        inicializarItem();
    }

    public void removerItem(ItemPedido itemPedido) {
        this.pedido.removerItem(itemPedido);
    }

    public void salvar() {
        try {
            pedidoService.salvar(pedido);
            Messages.addInfo(null, "Pedido salvo com sucesso!");
        } catch (ValidationException vex) {
            Messages.addError(null, vex.getMessage());
        }
    }

    public void finalizar() {
        pedidoService.finalizar(pedido);
        Messages.addInfo(null, "Pedido finalizado com sucesso!");
    }

    public boolean isPodeEditarPedido() {
        return pedido.isPedidoEditavel();
    }

    public boolean isPodeFinalizarPedido() {
        return pedido.getId() != null;
    }

    private void inicializarItem() {
        valorUnitario = BigDecimal.ZERO;
        quantidade = 0;
        veiculo = null;
        modelo = null;
        marca = null;
    }

    private void inicializarCombos() {
        clientes = clienteService.findAll();
        marcas = Arrays.asList(Marca.values());
        modeloPorMarca = modeloService.findModelosPorMarca();
        veiculosPorModelo = veiculoService.findVeiculosPorModelo();
    }

    public Collection<Modelo> getModelos() {
        if(marca != null) {
            return modeloPorMarca.get(marca);
        }
        return Collections.emptyList();
    }

    public Collection<Veiculo> getVeiculos() {
        if(modelo != null) {
            return veiculosPorModelo.get(modelo);
        }
        return Collections.emptyList();
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
