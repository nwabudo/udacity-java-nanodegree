package com.udacity.data.service;

import com.udacity.data.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        return new Plant();
    }
}