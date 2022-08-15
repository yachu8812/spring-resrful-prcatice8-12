package com.example.springresrfulprcatice.model.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;

}
