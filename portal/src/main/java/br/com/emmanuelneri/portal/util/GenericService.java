package br.com.emmanuelneri.portal.util;

import br.com.emmanuelneri.interfaces.Model;
import com.google.common.collect.Iterables;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericService<T extends Model> implements Serializable {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericService() {
        Class<?> clazz = getClass();
        do {
            if (clazz.getSuperclass().equals(GenericService.class)) {
                break;
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        this.type = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(Long id) {
        return this.entityManager.find(type, id);
    }

    public List<T> findAll() {
        return createSession().createCriteria(type).list();
    }

    @Transactional
    public void delete(T object) {
        this.entityManager.remove(object);
    }

    @Transactional
    public void create(T object) {
        this.entityManager.persist(object);
    }

    @Transactional
    public void update(T object) {
        this.entityManager.merge(object);
    }

    @Transactional
    public void save(T object) {
        if (object.getId() == null) {
            this.entityManager.persist(object);
        } else {
            this.entityManager.merge(object);
        }
    }

    protected Session createSession() {
        return (Session) this.entityManager.getDelegate();
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected Criteria getCriteria() {
        return createSession().createCriteria(type);
    }

    protected T getResultOrNull(List<T> list) {
        return Iterables.getFirst(list, null);
    }

}
