package com.example.demo.springframework.repositories;

import com.example.demo.springframework.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
