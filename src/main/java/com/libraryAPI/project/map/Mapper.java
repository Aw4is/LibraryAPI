//Maps entities to JSON -> Encapsulates logic for mapping
    //i.e convert entities/dtos to json

package com.libraryAPI.project.map;

//Generic classes A,B so can be any
public interface Mapper<A,B> {

    //maps a to b
    B mapTo(A a);

    //maps b to a
    A mapFrom(B b);
}
