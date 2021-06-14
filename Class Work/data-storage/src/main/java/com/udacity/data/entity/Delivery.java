package com.udacity.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String recipientName;

    @Column(name = "address_full", length = 500)
    private String recipientAddress;

    private LocalDateTime deliveryTime; // includes both date and time - simpler than having two separate fields

    @Type(type="yes_no")
    private Boolean isCompleted;

    // make sure to specify mappedBy. Lazy fetch optional,
    // but often a good idea for collection attributes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Plant> plants;

}
