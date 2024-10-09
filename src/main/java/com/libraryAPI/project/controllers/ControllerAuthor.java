//Controllers are part of the presentation layer hence present data to clients
//Provide endpoints for all CRUD operations (do not implement it themselves that is for the service layer)
//So handle requests by clients and give responses (can present data/status codes/error responses...)

//Mappers convert entities where DTOs will actually call and deal with them

package com.libraryAPI.project.controllers;
import com.libraryAPI.project.ServiceLayer.ServiceAuthors;
import com.libraryAPI.project.domain.dto.DtoAuthor;
import com.libraryAPI.project.domain.entities.AuthorEntity;
import com.libraryAPI.project.map.Implementations.AuthorMapperImpl;
import com.libraryAPI.project.map.Mapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ControllerAuthor {

    private ServiceAuthors authorService;

    //goes from entity to dto so fill parameters that way
    private Mapper<AuthorEntity, DtoAuthor> map;


    public ControllerAuthor(ServiceAuthors authorService, Mapper<AuthorEntity, DtoAuthor> map) {
        this.authorService = authorService;
        this.map = map;
    }

    //Creating author -> We create Dto first then convert it to entity prevent leaking
    @PostMapping(path = "/authors")
    public ResponseEntity<DtoAuthor> AuthortoCreate(@RequestBody DtoAuthor author){
        //Converts author dto to an entity
        AuthorEntity authorE = map.mapFrom(author);
        //Creates author using the entity in the database
        AuthorEntity storedAuthorE = authorService.createAuthor(authorE);
        return new ResponseEntity<>(map.mapTo(storedAuthorE), HttpStatus.CREATED); //ensures 201 returned

    }

    //Returns list of authors
    @GetMapping(path = "/authors")
    public List<DtoAuthor> returnListAuthors(){
        List<AuthorEntity> authorsList = authorService.findAll();
        //Takes all author in list, convert to DTO using mapper
        return authorsList.stream().map(map::mapTo).collect(Collectors.toList());
    }



}
