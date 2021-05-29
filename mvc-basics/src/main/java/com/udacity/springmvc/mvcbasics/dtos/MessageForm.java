package com.udacity.springmvc.mvcbasics.dtos;

import lombok.Data;

@Data
public class MessageForm {
    private String text;
    private String animalName;
    private String adjective;
}
