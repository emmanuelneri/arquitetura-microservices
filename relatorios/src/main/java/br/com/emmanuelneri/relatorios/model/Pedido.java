package br.com.emmanuelneri.relatorios.model;

import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.relatorios.model.enuns.SituacaoPedido;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Pedido.findPedidoCompletoById", query = "select p from Pedido p JOIN FETCH p.itens where p.id = :id"),
        @NamedQuery(name = "Pedido.findTopClientes", query = "select new br.com.emmanuelneri.relatorios.vo.ClienteRankingVo(c, count(i.quantidade), sum(i.valorTotal)) from Pedido p join p.cliente c join p.itens i where p.situacaoPedido <> 'CANCELADO' group by c order by sum(i.valorTotal) desc"),
        @NamedQuery(name = "Pedido.findTopVeiculo", query = "select new br.com.emmanuelneri.relatorios.vo.VeiculoRankingVo(v, count(i.quantidade)) from Pedido p join p.itens i join i.veiculo v where p.situacaoPedido <> 'CANCELADO' group by v order by count(i.quantidade) desc")
})
public class Pedido implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_criacao")
    private LocalDate dataCriacao = LocalDate.now();

    @Column(name = "data_finalizacao")
    private LocalDate dataFinalizacao;

    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacaoPedido = SituacaoPedido.ABERTO;

    public Pedido() {
    }

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionarItem(BigDecimal valorUnitario, int quantidade, Veiculo veiculo) {
        final ItemPedido itemPedido = new ItemPedido(valorUnitario, quantidade, veiculo);
        this.itens.add(itemPedido);
        this.valorTotal = this.valorTotal.add(itemPedido.getValorTotal());
    }

    public void removerItem(ItemPedido itemPedido) {
        this.itens.remove(itemPedido);
        this.valorTotal = this.valorTotal.subtract(itemPedido.getValorTotal());
    }

    @Override
    public Long getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public SituacaoPedido getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(SituacaoPedido situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

    public boolean isPedidoEditavel() {
        return getSituacaoPedido() == SituacaoPedido.ABERTO;
    }
}
