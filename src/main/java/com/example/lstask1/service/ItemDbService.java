package com.example.lstask1.service;

import com.example.lstask1.domian.Item;
import com.example.lstask1.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemDbService {

    private ItemRepository itemRepository;

    public Item saveItem(final Item item){
        return itemRepository.save(item);
    }

    public Optional<Item> findByGUID(final Long GUID){
        return itemRepository.findItemByGUID(GUID);
    }

}
