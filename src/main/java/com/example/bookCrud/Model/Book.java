package com.example.bookCrud.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book")
public class Book implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="book_id")
    public int bookId;
    @Column(name="book_name")
    public String bookName;
    @Column(name="genre")
    public String genre;
    @Column(name="author")
    public String author;
}
