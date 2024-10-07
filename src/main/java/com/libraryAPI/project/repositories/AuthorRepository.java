//Implements method to manage the database (which are called by service layer to actually manage it)
//Used to implement CRUD operations
//Part of the persistence layer

package com.libraryAPI.project.repositories;

import com.libraryAPI.project.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
}
