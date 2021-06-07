package com.udacity.bootstrap.dtos;

public class DogDTO {

    private String name;
    private String breed;
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public DogDTO() {
    }

    public DogDTO(String name, String breed, String origin) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public DogDTO(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

}
