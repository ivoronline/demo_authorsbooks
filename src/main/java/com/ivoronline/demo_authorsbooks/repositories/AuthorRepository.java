package com.ivoronline.demo_authorsbooks.repositories;

import com.ivoronline.demo_authorsbooks.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
