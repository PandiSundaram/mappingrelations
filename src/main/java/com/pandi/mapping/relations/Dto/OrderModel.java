package com.pandi.mapping.relations.Dto;

import com.pandi.mapping.relations.Entities.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Data
public class OrderModel {

    private String orderName;
    List<Map<String,String>> itemlist;

}
