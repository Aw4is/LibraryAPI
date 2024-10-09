package com.libraryAPI.project.ServiceLayer;

import com.libraryAPI.project.domain.entities.BookEntity;

import java.util.List;

public interface ServiceBook {

    BookEntity createBook(String isbn, BookEntity book);


    List<BookEntity> findAll();
}
