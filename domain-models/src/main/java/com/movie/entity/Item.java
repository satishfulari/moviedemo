package com.movie.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Item {

    private String name;
    private String desc;
    private int rating;
}
