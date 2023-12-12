package com.pandi.mapping.relations.Repository;

import com.pandi.mapping.relations.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
