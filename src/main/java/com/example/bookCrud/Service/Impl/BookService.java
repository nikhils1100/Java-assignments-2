package com.example.bookCrud.Service.Impl;

import com.example.bookCrud.Dao.Impl.BookDao;
import com.example.bookCrud.Model.Book;
import com.example.bookCrud.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements IBookService {


    private BookDao bookDao;

    @Override
    public void addBook(Book input) {
        bookDao.create(input);
    }

    @Override
    public void updateBook(Book input) {
        bookDao.update(input);
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.findOne(id);
    }

    @Override
    public void removeBookById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void removeBook(Book book){
        bookDao.delete(book);
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
