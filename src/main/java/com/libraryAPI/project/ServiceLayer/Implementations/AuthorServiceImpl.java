//Call CRUD operations on entites relating to authors

package com.libraryAPI.project.ServiceLayer.Implementations;

import com.libraryAPI.project.ServiceLayer.ServiceAuthors;
import com.libraryAPI.project.domain.entities.AuthorEntity;
import com.libraryAPI.project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements ServiceAuthors {


    private AuthorRepository authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    //Create author
    @Override
    public AuthorEntity createAuthor(AuthorEntity authorE) {
        return this.authorRepo.save(authorE);
    }
}
