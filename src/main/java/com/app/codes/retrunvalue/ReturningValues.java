package com.app.codes.retrunvalue;

import java.util.List;
import java.util.stream.Collectors;

public class ReturningValues {
    public final String value;
    public final int index;
    CheckValues checkValues = new CheckValues(3.3,false);
    public ReturningValues(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public <T> List<T> genericMethod(List<T> list) {
        return list.stream().collect(Collectors.toList());
    }

    public  <T>CheckValues checkMethod(T list) {

        return checkValues;
    }
}
