package com.example.bookCrud.Dao.Impl;

import com.example.bookCrud.Dao.Generics.AbstractJpaDao;
import com.example.bookCrud.Dao.IBookDao;
import com.example.bookCrud.Model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public class BookDao extends AbstractJpaDao<Book> implements IBookDao {
    public BookDao(EntityManager em){
        super(em);
        setClazz(Book.class);
    }
}
