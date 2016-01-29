package br.com.emmanuelneri.cadastros.shiro;

import br.com.emmanuelneri.cadastros.util.ApplicationProperty;
import br.com.emmanuelneri.integrador.autenticacao.UsuarioModuloRealm;
import br.com.emmanuelneri.integrador.properties.AbstractApplicationProperty;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class UsuarioRealm extends UsuarioModuloRealm {

    @Override
    protected AbstractApplicationProperty getAplicationProperty() {
        return BeanProvider.getContextualReference(ApplicationProperty.class, false);
    }
}
