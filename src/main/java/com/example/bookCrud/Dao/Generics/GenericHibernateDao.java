package com.example.bookCrud.Dao.Generics;

import java.io.Serializable;

public class GenericHibernateDao<T extends Serializable>
        extends AbstractHibernateDao<T>
        implements IGenericDao<T> {

}
