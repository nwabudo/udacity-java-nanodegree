package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(long id);

    List<String> retrieveDogNames();

    List<Dog> retrieveDogs();

    Dog retrieveDogById(long id);
}
