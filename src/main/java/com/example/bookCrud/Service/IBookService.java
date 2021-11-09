package com.example.bookCrud.Service;

import com.example.bookCrud.Model.Book;

import java.util.List;

public interface IBookService {
    public void addBook(Book p);
    public void updateBook(Book p);
    public List<Book> listBooks();
    public Book getBookById(int id);
    public void removeBookById(int id);
    public void removeBook(Book book);
}
