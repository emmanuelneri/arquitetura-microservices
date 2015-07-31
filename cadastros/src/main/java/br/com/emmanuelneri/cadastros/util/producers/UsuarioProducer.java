package br.com.emmanuelneri.cadastros.util.producers;

import br.com.emmanuelneri.cadastros.shiro.UsuarioVO;
import br.com.emmanuelneri.cadastros.util.anotations.UsuarioLogado;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioLogado
    public UsuarioVO getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(UsuarioVO.class);
    }

}