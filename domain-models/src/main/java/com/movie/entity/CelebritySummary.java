package com.movie.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CelebritySummary extends BaseDetails {
    private String birthday;
    private String knownForDepartment;
    private String biography;
}
