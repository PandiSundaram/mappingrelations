package com.pandi.mapping.relations.Controllers;


import com.pandi.mapping.relations.Dto.ItemModel;
import com.pandi.mapping.relations.Dto.OrderModel;
import com.pandi.mapping.relations.Entities.Item;
import com.pandi.mapping.relations.Entities.PersonalOrder;
import com.pandi.mapping.relations.Repository.OrderRepo;
import com.pandi.mapping.relations.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping
    public ResponseEntity save(@RequestBody OrderModel orderModel){

        PersonalOrder order = orderService.saveOrder(orderModel);

        return new ResponseEntity(order, HttpStatus.CREATED);

    }


    @PostMapping("/item")
    public ResponseEntity saveItem(@RequestBody ItemModel itemModel){

        Item item = orderService.saveItem(itemModel);

        return new ResponseEntity(item, HttpStatus.CREATED);

    }


    @GetMapping
    public ResponseEntity findall(){

        List<OrderModel>  orders = orderService.findall();

        return new ResponseEntity(orders, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity findallfet(){

        List<PersonalOrder>  orders = orderRepo.findAll();

        return new ResponseEntity(orders, HttpStatus.CREATED);

    }

    @GetMapping("/join/all")
    public ResponseEntity findallUsingJoin(){

        List<Object>  orders = orderRepo.findalljoin();

        return new ResponseEntity(orders, HttpStatus.CREATED);

    }



}
