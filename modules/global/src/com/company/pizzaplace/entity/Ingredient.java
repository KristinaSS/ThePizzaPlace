package com.company.pizzaplace.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "PIZZAPLACE_INGREDIENTS")
@Entity(name = "pizzaplace_Ingredients")
public class Ingredient extends StandardEntity {
    private static final long serialVersionUID = -7798104610284344065L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @JoinTable(name = "PIZZAPLACE_DISH_INGREDIENTS_LINK",
            joinColumns = @JoinColumn(name = "INGREDIENTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISH_ID"))
    @ManyToMany
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}