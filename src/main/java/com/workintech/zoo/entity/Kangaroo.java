package com.workintech.zoo.entity;


import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Kangaroo {
    private  Integer id;
    private  String name;
    private Double height;
    private  Double weight;
    private  String gender;
    private Boolean  isAggressive;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
