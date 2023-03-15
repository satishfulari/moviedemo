package com.movie.wrapper;

import com.movie.entity.BaseDetails;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EntityList<T extends BaseDetails> {

    @Builder.Default
    private List<T> objectList = new ArrayList<>();

}
