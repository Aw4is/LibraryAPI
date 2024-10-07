package com.libraryAPI.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryAPI.project.TestDataUtil;
import com.libraryAPI.project.domain.dto.DtoBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest  //as integration test
@ExtendWith(SpringExtension.class)
//DirtiesContext cleans database etween each method
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntTest {

    private MockMvc mvc;

    private ObjectMapper map;

    @Autowired
    public BookControllerIntTest(MockMvc mvc, ObjectMapper map) {
        this.mvc = mvc;
        this.map = new ObjectMapper();
    }

    @Test
    public void testCreateBook() throws Exception {
        DtoBook dtobook = TestDataUtil.createTestBookADTO(null);
        String JSONofDTOBook = map.writeValueAsString(dtobook);

        mvc.perform(
                MockMvcRequestBuilders.put("/books/978-1-2345-6789-0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONofDTOBook)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }

}
