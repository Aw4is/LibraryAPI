package com.libraryAPI.project.ServiceLayer.Implementations;

import com.libraryAPI.project.ServiceLayer.ServiceBook;
import com.libraryAPI.project.domain.entities.BookEntity;
import com.libraryAPI.project.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements ServiceBook {

    private BookRepository bookRepo;


    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    //Create Book
    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepo.save(book);
    }
}
