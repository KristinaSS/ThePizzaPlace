package com.company.pizzaplace.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "PIZZAPLACE_DELIVERED")
@Entity(name = "pizzaplace_Delivered")
public class Delivered extends StandardEntity {
    private static final long serialVersionUID = 4090039798785115552L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}