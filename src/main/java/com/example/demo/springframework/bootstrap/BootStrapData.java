package com.example.demo.springframework.bootstrap;

import com.example.demo.springframework.domain.Author;
import com.example.demo.springframework.domain.Book;
import com.example.demo.springframework.domain.Publisher;
import com.example.demo.springframework.repositories.AuthorRepository;
import com.example.demo.springframework.repositories.BookRepository;
import com.example.demo.springframework.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine1("");
        publisher.setCity("st Petersburg");
        publisher.setState("FL");

        publishRepository.save(publisher);

        System.out.println("Publisher count: " + publishRepository.count());


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBook().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publishRepository.save(publisher);

        Author rod = new Author("Rod","johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3545657677676");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBook().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publishRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher no of Books: " + publisher.getBook().size());

    }
}
