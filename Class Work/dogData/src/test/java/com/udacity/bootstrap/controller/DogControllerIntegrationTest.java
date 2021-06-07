package com.udacity.bootstrap.controller;

import com.udacity.bootstrap.entity.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs() throws Exception {

        ResponseEntity<List> response =
                this.restTemplate.withBasicAuth("user", "password")
                                 .getForEntity("http://localhost:" + port + "/dogs/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogById() throws Exception {
        ResponseEntity<Dog> response =
                this.restTemplate.withBasicAuth("user", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/1", Dog.class);
        Dog dog = response.getBody();

        assertThat("Not Equal to null", dog != null);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllDogBreed() throws Exception {
        ResponseEntity<List> response =
                this.restTemplate.withBasicAuth("user", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/breed", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedById() throws Exception {
        ResponseEntity<String> response =
                this.restTemplate.withBasicAuth("user", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/1/breed", String.class);

        String dogBreed = response.getBody();
        assertThat("Not Equal to null", dogBreed != null);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllDogName() throws Exception {
        ResponseEntity<List> response =
                this.restTemplate.withBasicAuth("user", "password")
                                 .getForEntity("http://localhost:" + port + "/dogs/name", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
