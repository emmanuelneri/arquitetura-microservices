package br.com.emmanuelneri.portal.service;

import br.com.emmanuelneri.portal.model.Usuario;
import br.com.emmanuelneri.portal.util.GenericService;

import javax.ejb.Stateless;

@Stateless
public class UsuarioService extends GenericService<Usuario> {

    public Usuario buscaParaLogin(String email) {
        return getResultOrNull(getEntityManager().createNamedQuery("Usuario.findByEmail", Usuario.class)
        .setParameter("email", email)
        .getResultList());
    }
}
