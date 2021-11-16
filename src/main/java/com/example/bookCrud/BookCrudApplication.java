package com.example.bookCrud;

import com.example.bookCrud.Dao.Impl.BookDao;
import com.example.bookCrud.Extras.HibernateUtil;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
public class BookCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCrudApplication.class, args);

		BookService bookService = new BookService();
		bookService.setBookDao(new BookDao());
		try{
			for(Book b :bookService.listBooks()){
				System.out.println(b.author);
			}
			Book newBook = new Book();
			newBook.bookName="ABC";
			newBook.author="Nikhil";
			newBook.genre="comedy";
			bookService.removeBookById(3);
			bookService.removeBook(newBook);
			for(Book b :bookService.listBooks()){
				System.out.println(b.author);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
//		try(Session session = HibernateUtil.getSessionFactory().openSession()){
//			Transaction transaction = session.beginTransaction();
//
//			List<Book> result = session.createQuery("from Book", Book.class).list();
//
//			result.forEach(book -> {
//				System.out.println(book.bookName	);
//			});
//
//			transaction.commit();
//			session.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}

}
