package br.com.emmanuelneri.relatorios.model;

import br.com.emmanuelneri.integrador.interfaces.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
        @NamedQuery(name = "Pedido.deleteItens", query = "delete from Pedido p where p.id = :id"),
        @NamedQuery(name = "Pedido.findTopClientes", query = "select new br.com.emmanuelneri.relatorios.vo.ClienteRankingVo(c, count(i.quantidade), sum(i.valorTotal)) from Pedido p join p.cliente c join p.itens i where p.situacaoPedido <> 'CANCELADO' group by c order by sum(i.valorTotal) desc"),
        @NamedQuery(name = "Pedido.findTopVeiculo", query = "select new br.com.emmanuelneri.relatorios.vo.VeiculoRankingVo(v, count(i.quantidade)) from Pedido p join p.itens i join i.veiculo v where p.situacaoPedido <> 'CANCELADO' group by v order by count(i.quantidade) desc")
})
public class Pedido implements Model<Long> {

    @Id
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
    private String situacaoPedido;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(String situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

}
