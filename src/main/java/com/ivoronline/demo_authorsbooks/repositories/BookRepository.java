package com.ivoronline.demo_authorsbooks.repositories;

import com.ivoronline.demo_authorsbooks.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}

