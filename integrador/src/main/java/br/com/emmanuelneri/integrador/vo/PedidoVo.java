package br.com.emmanuelneri.integrador.vo;

import br.com.emmanuelneri.integrador.json.LocalDateJsonAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PedidoVo implements Serializable {

    private Long id;
    private LocalDate dataCriacao;
    private LocalDate dataFinalizacao;
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private ClienteVo cliente;
    private UsuarioVo usuario;
    private List<ItemPedidoVo> itens;
    private String situacaoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlJavaTypeAdapter(LocalDateJsonAdapter.class)
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @XmlJavaTypeAdapter(LocalDateJsonAdapter.class)
    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ClienteVo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVo cliente) {
        this.cliente = cliente;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedidoVo> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoVo> itens) {
        this.itens = itens;
    }

    public String getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(String situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }
}
