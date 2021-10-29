package com.example.bookCrud;

import com.example.bookCrud.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BookCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCrudApplication.class, args);

		SessionFactory sessionFactory;
		// configures settings from hibernate.cfg.xml
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			List<Book> result = session.createQuery("from Person", Book.class).list();

			result.forEach(book -> {
				System.out.println(book.bookName);
			});

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
