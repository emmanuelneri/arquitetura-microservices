package br.com.emmanuelneri.portal.model.enuns;

public enum SituacaoPedido {

    ABERTO("Aberto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descricao;

    SituacaoPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
