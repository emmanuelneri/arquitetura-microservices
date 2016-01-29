package br.com.emmanuelneri.vendas.util.producers;

import br.com.emmanuelneri.integrador.anotations.UsuarioVoLogado;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.inject.Produces;

public final class UsuarioProducer {

    @Produces
    @UsuarioVoLogado
    public UsuarioVO getUsuarioLogado() {
        return SecurityUtils.getSubject().getPrincipals().oneByType(UsuarioVO.class);
    }

}