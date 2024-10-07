package com.libraryAPI.project.map.Implementations;

import com.libraryAPI.project.domain.dto.DtoAuthor;
import com.libraryAPI.project.domain.entities.AuthorEntity;
import com.libraryAPI.project.map.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, DtoAuthor> {

    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DtoAuthor mapTo(AuthorEntity authorEntity) {
        //Takes in author entity (left) and maps it to DtoAuthor class
        return modelMapper.map(authorEntity, DtoAuthor.class);
    }

    @Override
    public AuthorEntity mapFrom(DtoAuthor dtoAuthor) {
        return modelMapper.map(dtoAuthor, AuthorEntity.class);
    }
}
