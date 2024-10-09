//Call CRUD operations on entites relating to authors

package com.libraryAPI.project.ServiceLayer.Implementations;

import com.libraryAPI.project.ServiceLayer.ServiceAuthors;
import com.libraryAPI.project.domain.entities.AuthorEntity;
import com.libraryAPI.project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<AuthorEntity> findAll() {
        //returns iterable by default but we will use List instead for encapsulation
        //StreamSupport converts iterable to spliterator into a stream which we collect and map as list
        return StreamSupport.stream(authorRepo.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
