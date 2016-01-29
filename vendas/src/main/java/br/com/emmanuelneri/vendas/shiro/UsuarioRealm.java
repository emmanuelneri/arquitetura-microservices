package br.com.emmanuelneri.vendas.shiro;

import br.com.emmanuelneri.integrador.autenticacao.UsuarioModuloRealm;
import br.com.emmanuelneri.integrador.properties.AbstractApplicationProperty;
import br.com.emmanuelneri.vendas.util.ApplicationProperty;
import org.apache.deltaspike.core.api.provider.BeanProvider;


public class UsuarioRealm extends UsuarioModuloRealm {

    @Override
    protected AbstractApplicationProperty getAplicationProperty() {
        return BeanProvider.getContextualReference(ApplicationProperty.class, false);
    }

}

