package com.example.bookCrud;

import com.example.bookCrud.Dao.Impl.BookDao;
//import com.example.bookCrud.Extras.HibernateUtil;
import com.example.bookCrud.Extras.DbConfig;
import com.example.bookCrud.Model.Book;
import com.example.bookCrud.Service.Impl.BookService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.EntityManager;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class BookCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCrudApplication.class, args);
		EntityManager em = new DbConfig().getEntity("tenant_book_1");
		BookService bookService = new BookService();
		bookService.setBookDao(new BookDao(em));
		try{
			Book newBook = new Book();
			newBook.bookName="ABC";
			newBook.author="Nikhil";
			newBook.genre="comedy";
			bookService.addBook(newBook);
			for(Book b :bookService.listBooks()){
				System.out.println(b.bookId+" "+b.author);
			}

			bookService.removeBookById(4);
			bookService.removeBook(newBook);
			for(Book b :bookService.listBooks()){
				System.out.println(b.bookId+" "+b.author);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
