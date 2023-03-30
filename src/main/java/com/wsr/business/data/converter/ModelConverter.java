package com.wsr.business.data.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ModelConverter<T, D> {
    public abstract D convert(T model);

    public List<D> convert(List<T> list) {
        return list
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
