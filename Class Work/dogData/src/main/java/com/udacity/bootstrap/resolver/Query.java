package com.udacity.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exception.DogNotFoundException;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public  Iterable<Dog> findAllDogs(){
        return this.dogRepository.findAll();
    }

    public Dog findDogById(long id) {
        Optional<Dog> dogOptional = this.dogRepository.findById(id);
        return dogOptional.orElseThrow(() -> new DogNotFoundException("Dog with Id not found", id));
    }
}
