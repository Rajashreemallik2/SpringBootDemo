package com.example.demo.springframework.bootstrap;

import com.example.demo.springframework.domain.Author;
import com.example.demo.springframework.domain.Book;
import com.example.demo.springframework.repositories.AuthorRepository;
import com.example.demo.springframework.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3545657677676");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);


        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
