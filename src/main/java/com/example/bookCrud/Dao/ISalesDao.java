package com.example.bookCrud.Dao;

import com.example.bookCrud.Model.Sales;

import java.util.List;

public interface ISalesDao {
    Sales findOne(long id);

    List<Sales> findAll();

    Sales update(Sales entity);

    void delete(Sales entity);

    void deleteById(long entityId);
}
