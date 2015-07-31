package br.com.emmanuelneri.relatorios.util.producers;

import br.com.emmanuelneri.relatorios.shiro.UsuarioVO;
import br.com.emmanuelneri.relatorios.util.anotations.UsuarioLogado;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public UsuarioVO getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(UsuarioVO.class);
    }

}