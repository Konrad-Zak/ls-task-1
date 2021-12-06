package com.example.lstask1.mapper;

import com.example.lstask1.domian.Item;
import com.example.lstask1.domian.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapToItem(final ItemDto itemDto){
        return new Item(itemDto.getId(),itemDto.getGUID(),itemDto.getName());
    }

    public ItemDto mapToItemDto(final Item item){
        return new ItemDto(item.getId(),item.getGUID(),item.getName());
    }
}
