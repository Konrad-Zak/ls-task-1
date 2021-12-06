package com.example.lstask1.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "ID_GUID",unique = true)
    private Long GUID;

    @Column(name = "NAME")
    private String name;

}
