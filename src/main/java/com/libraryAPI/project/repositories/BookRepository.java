//Implements method to manage the database (which are called by service layer to actually manage it)
//Used to implement CRUD operations
//Part of the persistence layer

package com.libraryAPI.project.repositories;

import com.libraryAPI.project.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
