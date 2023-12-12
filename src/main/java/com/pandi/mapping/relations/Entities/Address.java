package com.pandi.mapping.relations.Entities;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Address {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String city;

}
