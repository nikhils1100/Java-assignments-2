package com.example.bookCrud.Dao.Generics;

import com.example.bookCrud.Extras.HibernateUtil;
import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> {
    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    // API
    public T findOne(final int id) {
        Transaction transaction = null;
        if(getCurrentSession().isJoinedToTransaction()) {
            transaction = getCurrentSession().getTransaction();
            T result = (T) getCurrentSession().get(clazz, id);
            return result;
        }
        else {
            transaction = getCurrentSession().beginTransaction();
        }
        T result = (T) getCurrentSession().get(clazz, id);
        transaction.commit();
        return result;
    }

    public List<T> findAll() {
        Transaction transaction = getCurrentSession().beginTransaction();
        List<T> result = getCurrentSession().createQuery("from " + clazz.getName()).list();
        transaction.commit();
        return  result;
    }

    public T create(final T entity) {
        Transaction transaction = getCurrentSession().beginTransaction();
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        transaction.commit();
        return entity;
    }

    public T update(final T entity) {
        Transaction transaction = getCurrentSession().beginTransaction();
        Preconditions.checkNotNull(entity);
        T result = (T) getCurrentSession().merge(entity);
        transaction.commit();
        return result;
    }

    public void delete(final T entity) {
        Transaction transaction = getCurrentSession().beginTransaction();
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
        transaction.commit();
    }

    public void deleteById(final int entityId)
    {
        Transaction transaction = getCurrentSession().beginTransaction();
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        getCurrentSession().delete(entity);
        transaction.commit();
    }

    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
