package com.ivoronline.demo_authorsbooks.services;

import com.ivoronline.demo_authorsbooks.entities.Author;

public interface ComboServiceInterface {
  String getBooks(Author author);
}
