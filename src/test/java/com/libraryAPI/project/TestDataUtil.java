package com.libraryAPI.project;

import com.libraryAPI.project.domain.dto.DtoAuthor;
import com.libraryAPI.project.domain.dto.DtoBook;
import com.libraryAPI.project.domain.entities.AuthorEntity;
import com.libraryAPI.project.domain.entities.BookEntity;


public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookA() {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .build();
    }

    public static BookEntity createTestBookB() {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .build();
    }

    public static BookEntity createTestBookC() {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .build();
    }

    public static DtoBook createTestBookADTO(final DtoAuthor author) {
        return DtoBook.builder()
                .isbn("978-1-2345-6789-1")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }
}
