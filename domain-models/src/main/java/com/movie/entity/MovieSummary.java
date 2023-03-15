package com.movie.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class MovieSummary extends BaseDetails{

    private List<String> genreIds;
    private List<String> cast;
}
