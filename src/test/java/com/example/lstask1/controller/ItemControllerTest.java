package com.example.lstask1.controller;

import com.example.lstask1.domian.ItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemController itemController;

    @Test
    public void addItem() throws Exception {
        //Given
        ItemDto itemDto = new ItemDto(1L,200L,"Toy");
        when(itemController.addItem(200L,"Toy")).thenReturn(itemDto);

        //When & Then
        mockMvc.perform(post("/api?GUID=200&Name=Toy")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.guid", is(200)))
                .andExpect(jsonPath("$.name", is("Toy")));
    }

    @Test
    public void getItem() throws Exception {
        //Given
        ItemDto itemDto = new ItemDto(1L,200L,"Toy");
        when(itemController.getItem(200L)).thenReturn(itemDto);
        //When & Then
        mockMvc.perform(get("/api?GUID=200")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.guid", is(200)))
                .andExpect(jsonPath("$.name", is("Toy")));
    }
}
