package com.example.bookCrud.Dao.Impl;

import com.example.bookCrud.Dao.Generics.AbstractHibernateDao;
import com.example.bookCrud.Dao.Generics.AbstractJpaDao;
import com.example.bookCrud.Dao.IBookDao;
import com.example.bookCrud.Model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends AbstractJpaDao<Book> implements IBookDao {
    public BookDao(){
        super();
        setClazz(Book.class);
    }
}
