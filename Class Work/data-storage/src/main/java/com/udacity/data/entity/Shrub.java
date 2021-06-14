package com.udacity.data.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Shrub extends Plant {

    private double height;

    private double width;
}
