//Convert entities to JSON -> reside in service layer or in between service and presentation layer
//That way entities do not leak into the presentation layer - the presentation layer should have
    //no knowledge about the internal workings, its simply to present the data
    //leak as we will have to use them in controllers *which are in presentation layer*
    //Hence DTO act as a middle-man to prevent this


package com.libraryAPI.project.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Provide getters and setters
@AllArgsConstructor
@NoArgsConstructor //Jackson uses this to create null object then fills said object using getters/setters
@Builder
public class DtoAuthor {

    private Long id;

    private String name;

    private Integer age;



}
