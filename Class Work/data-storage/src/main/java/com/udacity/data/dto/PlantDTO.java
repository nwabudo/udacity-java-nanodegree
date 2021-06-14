package com.udacity.data.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlantDTO {

    private String name;

    private BigDecimal price;
}
