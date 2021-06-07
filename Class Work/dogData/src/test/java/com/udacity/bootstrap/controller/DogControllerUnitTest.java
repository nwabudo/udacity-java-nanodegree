package com.udacity.bootstrap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.udacity.bootstrap.DogApplication;
import com.udacity.bootstrap.dtos.DogDTO;
import com.udacity.bootstrap.service.DogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(context)
                .apply(springSecurity()).build();
    }

    @Test
    //@WithMockUser(username = "test", password = "test", roles = "USER")
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs").with(httpBasic("user","password")))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    public void getDogById() throws Exception {
        mockMvc.perform(get("/dogs/1").with(httpBasic("user","password")))
               .andDo(print())
               .andExpect(status().isOk())
               .andDo(print());
        verify(dogService, times(1)).retrieveDogById(1);
    }

    @Test
    public void getAllDogBreed() throws Exception {
        mockMvc.perform(get("/dogs/breed").with(httpBasic("user","password")))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"))
               .andDo(print());

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    public void getDogBreedById() throws Exception {
        mockMvc.perform(get("/dogs/1/breed").with(httpBasic("user","password")))
               .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(1);
    }

    @Test
    public void getAllDogName() throws Exception {
        mockMvc.perform(get("/dogs/name").with(httpBasic("user","password")))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogNames();
    }
    @Test
    public void insertNewDog() throws Exception {
        DogDTO anObject = new DogDTO();
        anObject.setName("milly");
        anObject.setBreed("Bull Dog");
        anObject.setOrigin("Calabar");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

        String requestJson=ow.writeValueAsString(anObject);

        mockMvc.perform(post("/dogs")
                .with(httpBasic("user","password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(status().isOk());
//               //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//               .andExpect(jsonPath("$.breed").value(anObject.getBreed()))
//               .andExpect(jsonPath("$.origin").value(anObject.getOrigin()))
//               .andExpect(jsonPath("$.name").value(anObject.getName()));

    }


}
