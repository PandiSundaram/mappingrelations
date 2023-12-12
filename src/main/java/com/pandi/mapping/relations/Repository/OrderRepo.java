package com.pandi.mapping.relations.Repository;


import com.pandi.mapping.relations.Entities.PersonalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<PersonalOrder,Integer> {


//    @Query(value="SELECT * FROM mappingpractice.personal_order JOIN mappingpractice.item ON mappingpractice.personal_order.id = mappingpractice.item.order_id;",nativeQuery = true)
//    public String findalljoin();

    @Query(value="SELECT * FROM personal_order p LEFT JOIN item i ON p.id=i.order_id",nativeQuery = true)
    public List<Object> findalljoin();

}
