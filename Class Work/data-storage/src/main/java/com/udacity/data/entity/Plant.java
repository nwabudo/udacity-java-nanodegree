package com.udacity.data.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.data.dto.Views;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

// Uses InheritanceType.JOINED to store shared fields in 'plant' and unique fields
// in subclass tables
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4)
    private BigDecimal price;

    //many plants can belong to one delivery,
    // don't retrieve delivery if we don't need it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")  //map the join column in the plant table
    private Delivery delivery;
}
