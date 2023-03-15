package com.movie.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {

    private String movieId;
    private int rating;
}
