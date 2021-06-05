package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("select d.breed from Dog d")
    List<String> findAllDogBreed();

    @Query("select d.breed from Dog d where d.id = ?1")
    String findDogBreedById(long id);

    @Query("select d.name from Dog d")
    List<String> findAllDogNames();

    void deleteByBreed(String breed);

    List<Dog> findByBreed(String breed);
}
