package com.libraryAPI.project.domain.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Provide getters and setters
@AllArgsConstructor
@NoArgsConstructor //Jackson uses this to create null object then fills said object using getters/setters
@Builder
public class DtoBook {


    private String isbn;

    private String title;

    private DtoAuthor author;





}
