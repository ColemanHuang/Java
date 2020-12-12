package com.demo;

public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException() {
    }

    public IngredientSortOutException(String message) {
        super(message);
    }

    public IngredientSortOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientSortOutException(Throwable cause) {
        super(cause);
    }
}
