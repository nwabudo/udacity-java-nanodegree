package com.udacity.bootstrap.service.impl;

import com.udacity.bootstrap.dtos.DogDTO;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exception.DogServiceException;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.service.DogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<String> retrieveDogBreed() {
        return this.dogRepository.findAllDogBreed();
    }

    @Override
    public String retrieveDogBreedById(long id) {
        Optional<String> optionalBreed = Optional.ofNullable(this.dogRepository.findDogBreedById(id));
        String breed = optionalBreed.orElseThrow(() -> new DogServiceException("Dog with Id not found", id));
        return breed;
    }

    @Override
    public List<String> retrieveDogNames() {
        return this.dogRepository.findAllDogNames();
    }

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog retrieveDogById(long id) {
        Optional<Dog> optionalDog = this.dogRepository.findById(id);
        Dog dog = optionalDog.orElseThrow(() -> new DogServiceException("Dog with Id not found", id));
        return dog;
    }

    @Override
    public Dog insertNewDog(DogDTO dogDTO) {
        Dog dog = new Dog(dogDTO.getName(), dogDTO.getBreed(), dogDTO.getOrigin());
        try{
            dog = this.dogRepository.save(dog);
        }catch(Exception ex){
            throw new DogServiceException("Error Inserting new Dog with name", dogDTO.getName());
        }
        return dog;
    }
}
