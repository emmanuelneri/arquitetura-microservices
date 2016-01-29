package br.com.emmanuelneri.vendas.model;

import br.com.emmanuelneri.integrador.interfaces.Model;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "item_pedido")
public class ItemPedido implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @NotNull
    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @Transient
    private VeiculoVo veiculo;

    protected ItemPedido() {

    }

    public ItemPedido(BigDecimal valorUnitario, int quantidade, VeiculoVo veiculo) {
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
        this.veiculo = veiculo;
    }

    @PrePersist
    @PreUpdate
    protected void atualizarIdVeiculo() {
        this.idVeiculo = veiculo.getId();
    }

    @Override
    public Long getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public VeiculoVo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoVo veiculo) {
        this.veiculo = veiculo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(valorUnitario, that.valorUnitario) &&
                Objects.equals(veiculo, that.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorUnitario, veiculo);
    }
}
