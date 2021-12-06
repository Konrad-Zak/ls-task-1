package com.example.lstask1.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private Long GUID;
    private String Name;

    public ItemDto(Long GUID, String name) {
        this.GUID = GUID;
        Name = name;
    }
}
