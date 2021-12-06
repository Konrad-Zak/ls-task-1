package com.example.lstask1.service;

import com.example.lstask1.domian.Item;
import com.example.lstask1.domian.ItemDto;
import com.example.lstask1.exception.ItemNotFoundException;
import com.example.lstask1.mapper.ItemMapper;
import com.example.lstask1.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemDbServiceTest {

    @Autowired
    private ItemDbService itemDbService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void saveItem(){
        //Given
        ItemDto itemDto = new ItemDto(200L,"toy");
        Item item = itemMapper.mapToItem(itemDto);
        //When
        itemDbService.saveItem(item);
        Item itemResult = itemRepository.findById(item.getId()).orElse(new Item(1000L,2L,"XXX"));
        //Then
        assertEquals(item.getId(),itemResult.getId());
        assertEquals(item.getGUID(),itemResult.getGUID());
        assertEquals(item.getName(),itemResult.getName());
        //ClenUp
        itemRepository.deleteAll();
    }

    @Test
    public void getItem(){
        //Given
        Long GUID = 200L;
        ItemDto itemDto = new ItemDto(GUID,"toy");
        Item item = itemMapper.mapToItem(itemDto);
        itemRepository.save(item);
        //When
        Item itemResult = itemDbService.findByGUID(GUID).orElse(new Item(1000L,2L,"XXX"));
        //Then
        assertEquals(item.getId(),itemResult.getId());
        assertEquals(item.getGUID(),itemResult.getGUID());
        assertEquals(item.getName(),itemResult.getName());
        //ClenUp
        itemRepository.deleteAll();
    }

    @Test
    public void getItemWithException(){
        //Given
        Long GUID = 1L;
        boolean result;
        //When
        try {
            itemDbService.findByGUID(GUID).orElseThrow(ItemNotFoundException::new);
            result = true;
        } catch (ItemNotFoundException itemNotFoundException){
            result = false;
        }
        //Then
        assertFalse(result);
    }



}
