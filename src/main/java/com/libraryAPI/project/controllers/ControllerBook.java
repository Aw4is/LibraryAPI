//Controllers are part of the presentation layer hence present data to clients
//Provide endpoints for all CRUD operations (do not implement it themselves that is for the service layer)
//So handle requests by clients and give responses (can present data/status codes/error responses...)

//All methods below return JSON automatically

package com.libraryAPI.project.controllers;


import com.libraryAPI.project.ServiceLayer.ServiceBook;
import com.libraryAPI.project.domain.dto.DtoBook;
import com.libraryAPI.project.domain.entities.BookEntity;
import com.libraryAPI.project.map.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ControllerBook {

    private Mapper<BookEntity, DtoBook> mapBook;

    private ServiceBook bookService;

    public ControllerBook(Mapper<BookEntity, DtoBook> mapBook, ServiceBook bookService) {
        this.mapBook = mapBook;
        this.bookService = bookService;
    }


    //Pathvariable used to extract isbn from URI and place it into isbn to create a path
    //RequestBody to convert body of JSON file into a DtoBook object automatically
    @PutMapping("/books/{isbn}")
        public ResponseEntity<DtoBook> createBook(@PathVariable("isbn") String isbn,
                                                  @RequestBody DtoBook dtobook){

        BookEntity bookE = mapBook.mapFrom(dtobook);
        BookEntity storedBook = bookService.createBook(isbn, bookE);
        DtoBook storedBookDTO = mapBook.mapTo(storedBook);
        return new ResponseEntity<>(storedBookDTO, HttpStatus.CREATED);

    }

    @GetMapping(path = "/books")
    public List<DtoBook> returnListBooks(){
        List<BookEntity> books = bookService.findAll();
       return books.stream().map(mapBook::mapTo).collect(Collectors.toList());
    }

}
