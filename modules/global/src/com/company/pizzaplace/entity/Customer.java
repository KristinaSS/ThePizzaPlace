package com.company.pizzaplace.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "PIZZAPLACE_CUSTOMER")
@Entity(name = "pizzaplace_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 18277095209157845L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    protected String email;

    @NotNull
    @Column(name = "NUMBER_OF_ORDERS", nullable = false)
    protected Integer numberOfOrders;

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}