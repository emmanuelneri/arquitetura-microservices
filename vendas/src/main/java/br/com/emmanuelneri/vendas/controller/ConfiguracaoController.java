package br.com.emmanuelneri.vendas.controller;

import br.com.emmanuelneri.autenticacao.Usuario;
import br.com.emmanuelneri.vendas.util.anotations.UsuarioLogado;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ConfiguracaoController {

    @Inject
    @ConfiguracaoAplicacao
    private Configuracao configuracao;

    @Inject
    @UsuarioLogado
    private Usuario usuario;

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
