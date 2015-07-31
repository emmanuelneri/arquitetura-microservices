package br.com.emmanuelneri.portal.shiro;


public final class ModuloVO {

    private final String nome;
    private final String chave;
    private final String url;

    public ModuloVO(String nome, String chave, String url) {
        this.nome = nome;
        this.chave = chave;
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public String getChave() {
        return chave;
    }

    public String getUrl() {
        return url;
    }
}
