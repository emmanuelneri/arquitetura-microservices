package br.com.emmanuelneri.vendas.model;

import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.vendas.model.enuns.SituacaoPedido;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Pedido.findPedidoCompletoById", query = "select p from Pedido p JOIN FETCH p.itens where p.id = :id"),
        @NamedQuery(name = "Pedido.findTopClientes", query = "select new br.com.emmanuelneri.integrador.vo.ClienteRankingVo(p.idCliente, count(i.quantidade), sum(i.valorTotal)) from Pedido p join p.itens i where p.situacaoPedido <> 'CANCELADO' group by p.idCliente order by sum(i.valorTotal) desc"),
        @NamedQuery(name = "Pedido.findTopVeiculo", query = "select new br.com.emmanuelneri.integrador.vo.VeiculoRankingVo(i.idVeiculo, count(i.quantidade)) from Pedido p join p.itens i  where p.situacaoPedido <> 'CANCELADO' group by i.idVeiculo order by count(i.quantidade) desc")
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
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacaoPedido = SituacaoPedido.ABERTO;

    @Transient
    private ClienteVo cliente;

    public Pedido() {
    }

    public Pedido(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void adicionarItem(BigDecimal valorUnitario, int quantidade, VeiculoVo veiculo) {
        final ItemPedido itemPedido = new ItemPedido(valorUnitario, quantidade, veiculo);
        this.itens.add(itemPedido);
        this.valorTotal = this.valorTotal.add(itemPedido.getValorTotal());
    }

    public void removerItem(ItemPedido itemPedido) {
        this.itens.remove(itemPedido);
        this.valorTotal = this.valorTotal.subtract(itemPedido.getValorTotal());
    }

    @PrePersist
    @PreUpdate
    protected void atualizarIdCliente() {
        this.idCliente = cliente.getId();
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

    public ClienteVo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVo cliente) {
        this.cliente = cliente;
    }

    public Long getIdUsuario() {
        return idUsuario;
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

    public Long getIdCliente() {
        return idCliente;
    }
}
