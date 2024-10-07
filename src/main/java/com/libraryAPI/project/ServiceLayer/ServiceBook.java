package com.libraryAPI.project.ServiceLayer;

import com.libraryAPI.project.domain.entities.BookEntity;

public interface ServiceBook {

    BookEntity createBook(String isbn, BookEntity book);


}
