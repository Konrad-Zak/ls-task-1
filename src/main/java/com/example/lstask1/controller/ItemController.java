package com.example.lstask1.controller;

import com.example.lstask1.domian.Item;
import com.example.lstask1.domian.ItemDto;
import com.example.lstask1.exception.ItemNotFoundException;
import com.example.lstask1.mapper.ItemMapper;
import com.example.lstask1.service.ItemDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private ItemMapper itemMapper;
    private ItemDbService itemDbService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ItemDto addItem(@RequestParam Long GUID, @RequestParam String Name){
        ItemDto itemDto = new ItemDto(GUID,Name);
        LOGGER.info("Attempt to add: ID_GUID=" + itemDto.getGUID() + " Name=" + itemDto.getName());
        return itemMapper.mapToItemDto(itemDbService.saveItem(itemMapper.mapToItem(itemDto)));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(method = RequestMethod.GET)
    public ItemDto getItem(@RequestParam Long GUID){
        LOGGER.info("Attempt to get item with ID_GUID=" + GUID);
        Item item = itemDbService.findByGUID(GUID).orElseThrow(ItemNotFoundException::new);
        return itemMapper.mapToItemDto(item);
    }

}
