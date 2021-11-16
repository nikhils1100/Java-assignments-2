package com.example.bookCrud.Dao.Impl;

import com.example.bookCrud.Dao.Generics.AbstractHibernateDao;
import com.example.bookCrud.Dao.Generics.AbstractJpaDao;
import com.example.bookCrud.Dao.ISalesDao;
import com.example.bookCrud.Model.Sales;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDao extends AbstractJpaDao<Sales> implements ISalesDao {
    public SalesDao(){
        super();
        setClazz(Sales.class);
    }
}
