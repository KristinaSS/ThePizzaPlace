package com.company.pizzaplace.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PizzaSize implements EnumClass<String> {

    SMALL("10"),
    MEDIUM("20"),
    LARGE("30");

    private String id;

    PizzaSize(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PizzaSize fromId(String id) {
        for (PizzaSize at : PizzaSize.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}