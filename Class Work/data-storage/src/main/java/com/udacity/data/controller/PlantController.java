package com.udacity.data.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.data.dto.PlantDTO;
import com.udacity.data.dto.Views;
import com.udacity.data.entity.Plant;
import com.udacity.data.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @RequestMapping("/dto/{name}")
    public PlantDTO getPlantDTO(@PathVariable("name") String name){
        Plant plant = plantService.getPlantByName(name);
        return mapToDto(plant);
    }

    @JsonView(Views.Public.class)
    @RequestMapping("/entity/{name}")
    public Plant getFilteredPlant(@PathVariable("name") String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO mapToDto(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}