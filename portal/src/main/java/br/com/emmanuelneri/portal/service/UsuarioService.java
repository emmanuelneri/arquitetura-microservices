package br.com.emmanuelneri.portal.service;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.GenericService;

import javax.inject.Named;

@Named
public class UsuarioService extends GenericService<Usuario> {

    public Usuario findCompletoByEmail(String email) {
        return getResultOrNull(getEntityManager().createNamedQuery("Usuario.findCompletoByEmail", Usuario.class)
        .setParameter("email", email)
        .getResultList());
    }

    public Usuario findByEmail(String email) {
        return getResultOrNull(getEntityManager().createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", email)
                .getResultList());
    }
}
