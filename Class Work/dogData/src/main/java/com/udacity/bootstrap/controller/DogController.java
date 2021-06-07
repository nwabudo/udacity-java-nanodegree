//package com.udacity.bootstrap.controller;
//
//import com.udacity.bootstrap.entity.Dog;
//import com.udacity.bootstrap.service.DogService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.List;
//
//@RestController
//@RequestMapping("dogs")
//public class DogController {
//
//    private DogService dogService;
//
//    public DogController(DogService dogService) {
//        this.dogService = dogService;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<Dog>> getAllDogs() {
//        List<Dog> list = dogService.retrieveDogs();
//        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
//    }
//
//    @GetMapping("/breed")
//    public ResponseEntity<List<String>> getAllDogBreed(){
//        List<String> dogBreeds = this.dogService.retrieveDogBreed();
//        HttpStatus status;
//        if(dogBreeds == null || dogBreeds.isEmpty()){
//            status = HttpStatus.NOT_FOUND;
//            dogBreeds =  Collections.emptyList();
//        }else status = HttpStatus.OK;
//
//        return new ResponseEntity<>(dogBreeds, status);
//    }
//
//    @GetMapping("/{id}/breed")
//    public ResponseEntity<String> getDogBreedById(@PathVariable("id") long id){
//        String dogBreed = this.dogService.retrieveDogBreedById(id);
//        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
//    }
//
//    @GetMapping("/name")
//    public ResponseEntity<List<String>> getAllDogName(){
//        List<String> dogNames = this.dogService.retrieveDogNames();
//        HttpStatus status;
//        if(dogNames == null || dogNames.isEmpty()){
//            status = HttpStatus.NOT_FOUND;
//            dogNames =  Collections.emptyList();
//        }else status = HttpStatus.OK;
//
//        return new ResponseEntity<>(dogNames, status);
//    }
//}
