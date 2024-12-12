package com.app.codes.practice.steam.exception;

import java.util.function.Function;

public class ExceptionUtil {
    public static <T, R> Function<T, R> wrap(CheckedFunction<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

