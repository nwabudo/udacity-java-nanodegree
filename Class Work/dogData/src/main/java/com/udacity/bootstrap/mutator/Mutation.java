package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exception.DogNotFoundException;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){
        //this.dogRepository.deleteByBreed(breed);
        List<Dog> dogByBreed = (List<Dog>)this.dogRepository.findByBreed(breed);
        if(dogByBreed == null || dogByBreed.isEmpty()) throw new DogNotFoundException("No Dog with Breed Found", breed);
        this.dogRepository.deleteAll(dogByBreed);
        return true;
    }

    public Dog updateDogName(String newName, long id){
        Optional<Dog> optionalDog = this.dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dog = this.dogRepository.save(dog);
            return dog;
        }else{
            throw new DogNotFoundException("Dog with id not Found", id);
        }
    }

    public Dog insertNewDog(String name, String breed, String origin){
        Dog dog = new Dog(name, breed, origin);
        dog = this.dogRepository.save(dog);
        return dog;
    }
}
