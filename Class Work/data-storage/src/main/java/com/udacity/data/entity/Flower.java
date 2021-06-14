package com.udacity.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Flower extends Plant {

    private String color;

}
