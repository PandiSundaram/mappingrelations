package com.pandi.mapping.relations.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderName;
    private OffsetDateTime offsetDateTime;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "personalOrder")
    @JsonManagedReference
    private List<Item> items;
}
