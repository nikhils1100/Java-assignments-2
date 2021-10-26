package com.example.bookCrud.Dao;

import com.example.bookCrud.Dao.Generics.AbstractHibernateDao;
import com.example.bookCrud.Dao.Generics.GenericHibernateDao;
import com.example.bookCrud.Dao.Generics.IBookDao;
import com.example.bookCrud.Model.Book;

public class BookDao extends AbstractHibernateDao<Book> implements IBookDao {
    public BookDao(){
        super();
        setClazz(Book.class);
    }
}
