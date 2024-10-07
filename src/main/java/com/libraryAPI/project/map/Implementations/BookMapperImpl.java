package com.libraryAPI.project.map.Implementations;

import com.libraryAPI.project.domain.dto.DtoBook;
import com.libraryAPI.project.domain.entities.BookEntity;
import com.libraryAPI.project.map.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, DtoBook> {

    private ModelMapper map;


    public BookMapperImpl(ModelMapper map) {
        this.map = map;
    }

    @Override
    public DtoBook mapTo(BookEntity bookEntity) {
        return map.map(bookEntity, DtoBook.class);
    }

    @Override
    public BookEntity mapFrom(DtoBook dtoBook) {
        return map.map(dtoBook, BookEntity.class);
    }
}
