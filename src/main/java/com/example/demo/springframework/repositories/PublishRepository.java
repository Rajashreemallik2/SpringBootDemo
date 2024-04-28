package com.example.demo.springframework.repositories;

import com.example.demo.springframework.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {

}
