package com.example.lstask1.repository;

import com.example.lstask1.domian.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Override
    Item save(Item item);

    Optional<Item> findItemByGUID(Long GUID);

}
