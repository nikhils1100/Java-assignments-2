package com.example.bookCrud.Dao;

import com.example.bookCrud.Model.Book;

import java.util.List;

public interface IBookDao {
    Book findOne(long id);

    List<Book> findAll();

    Book update(Book entity);

    void delete(Book entity);

    void deleteById(long entityId);

}
