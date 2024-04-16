package com.example.demo.springframework.repositories;

import com.example.demo.springframework.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
