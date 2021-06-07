package com.udacity.bootstrap.controller;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running.")
})
@Api(value = "DogAPI",tags = {"Dog API"})
@RequestMapping("dogs")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable("id") long id) {
        Dog dog = dogService.retrieveDogById(id);
        return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> getAllDogBreed(){
        List<String> dogBreeds = this.dogService.retrieveDogBreed();
        HttpStatus status;
        if(dogBreeds == null || dogBreeds.isEmpty()){
            status = HttpStatus.NOT_FOUND;
            dogBreeds =  Collections.emptyList();
        }else status = HttpStatus.OK;

        return new ResponseEntity<>(dogBreeds, status);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") long id){
        String dogBreed = this.dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getAllDogName(){
        List<String> dogNames = this.dogService.retrieveDogNames();
        HttpStatus status;
        if(dogNames == null || dogNames.isEmpty()){
            status = HttpStatus.NOT_FOUND;
            dogNames =  Collections.emptyList();
        }else status = HttpStatus.OK;

        return new ResponseEntity<>(dogNames, status);
    }
}
