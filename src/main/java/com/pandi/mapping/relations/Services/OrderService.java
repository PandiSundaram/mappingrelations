package com.pandi.mapping.relations.Services;

import com.pandi.mapping.relations.Dto.ItemModel;
import com.pandi.mapping.relations.Dto.OrderModel;
import com.pandi.mapping.relations.Entities.Item;
import com.pandi.mapping.relations.Entities.PersonalOrder;
import com.pandi.mapping.relations.Repository.ItemRepo;
import com.pandi.mapping.relations.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderService {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ItemRepo itemRepo;

    public PersonalOrder saveOrder(OrderModel orderModel){

        PersonalOrder order = new PersonalOrder();
        order.setOrderName(orderModel.getOrderName());
        order.setOffsetDateTime(OffsetDateTime.now());
//        List<Item> items = new ArrayList<>();
//        orderModel.getItemlist().forEach(i -> {
//            Item item = new Item();
//            item.setItemName(i.get("name"));
//            item.setPrice(BigDecimal.valueOf(Long.valueOf(i.get("price"))));
//            item.setQuantity(Integer.parseInt(i.get("quantity")));
//           // item.setPersonalOrder(order);
//            items.add(item);
//        });
//        order.setItems(items);

       return orderRepo.save(order);
    }


    public Item saveItem(ItemModel itemModel){


            Item item = new Item();
            item.setItemName(itemModel.getItemName());
            item.setPrice(itemModel.getPrice());
            item.setQuantity(itemModel.getQuantity());
            PersonalOrder personalOrder = new PersonalOrder();
            personalOrder.setId(itemModel.getOrderId());
            item.setPersonalOrder(personalOrder);

           itemRepo.save(item);
           return item;
    }
    public  List<OrderModel>  findall(){

       List<PersonalOrder> orderList = orderRepo.findAll();
       List<OrderModel> orderModelList = new ArrayList<>();

       if(!orderList.isEmpty()){
           orderList.forEach(order -> {
               OrderModel orderModel = new OrderModel();
               orderModel.setOrderName(order.getOrderName());
               orderModel.setItemlist(getitems(order.getItems()));
               orderModelList.add(orderModel);
           });
       }

       return orderModelList;
    }

    public List<Map<String,String>> getitems(List<Item> items){

        List<Map<String,String>> li = new ArrayList<>();

        items.forEach(item -> {
            HashMap<String,String> map = new HashMap<>();
            map.put("name",item.getItemName());
            map.put("price",item.getPrice().toString());
            map.put("quantity",item.getQuantity().toString());
            li.add(map);
        });

        return li;
    }

}
