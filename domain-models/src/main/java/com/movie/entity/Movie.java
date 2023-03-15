package com.movie.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Movie extends BaseDetails{

    private String overview;
}
