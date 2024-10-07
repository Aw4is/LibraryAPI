//Service layer for authors
//Calls and Manages CRUD operations (in persistence layer) hence manages the database

package com.libraryAPI.project.ServiceLayer;

import com.libraryAPI.project.domain.entities.AuthorEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface ServiceAuthors {

    AuthorEntity createAuthor(AuthorEntity author);



}
