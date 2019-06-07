package com.company.pizzaplace.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "PIZZAPLACE_DISH")
@Entity(name = "pizzaplace_Dish")
public class Dish extends StandardEntity {
    private static final long serialVersionUID = -3829296571127195964L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISH_TYPE_ID")
    protected DishType dishType;

    @Column(name = "DISH_SIZE")
    protected String dishSize;

    @JoinTable(name = "PIZZAPLACE_DISH_INGREDIENTS_LINK",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENTS_ID"))
    @ManyToMany
    protected List<Ingredient> ingredients;

    @JoinTable(name = "PIZZAPLACE_ORDER_DISH_LINK",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    @ManyToMany
    protected List<Order> orders;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISH_PHOTO_ID")
    protected FileDescriptor dishPhoto;

    public FileDescriptor getDishPhoto() {
        return dishPhoto;
    }

    public void setDishPhoto(FileDescriptor dishPhoto) {
        this.dishPhoto = dishPhoto;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public PizzaSize getDishSize() {
        return dishSize == null ? null : PizzaSize.fromId(dishSize);
    }

    public void setDishSize(PizzaSize dishSize) {
        this.dishSize = dishSize == null ? null : dishSize.getId();
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}