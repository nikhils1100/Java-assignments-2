package com.example.bookCrud.Dao;

import com.example.bookCrud.Model.Book;
import com.example.bookCrud.Model.User;

import java.util.List;

public interface IUserDao {
    User findOne(long id);

    List<User> findAll();

    User update(User entity);

    void delete(User entity);

    void deleteById(long entityId);
}
