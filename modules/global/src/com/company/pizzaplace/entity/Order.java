package com.company.pizzaplace.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NamePattern("%s %s|name,address")
@Table(name = "PIZZAPLACE_ORDER")
@Entity(name = "pizzaplace_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -2337471543640783744L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @NotNull
    @Column(name = "TELEPHONE_NUMBER", nullable = false)
    protected String telephoneNumber;

    @NotNull
    @Column(name = "ORDER_TIME", nullable = false)
    protected LocalDateTime orderTime;

    @Column(name = "TOTAL_AMOUNT")
    protected BigDecimal totalAmount;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected List<DishQuantity> lines;

    @NotNull
    @Column(name = "DISCOUNT", nullable = false)
    protected BigDecimal discount;

    @NotNull
    @Column(name = "FINAL_AMOUNT", nullable = false)
    protected BigDecimal finalAmount;

    @Column(name = "IS_DELIVERED")
    protected Boolean isDelivered;

    @Column(name = "DELIVERY_TIME")
    protected LocalDateTime deliveryTime;

    @Lob
    @Column(name = "SPECIAL_DELIVERY_INSTRUCTIONS")
    protected String specialDeliveryInstructions;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    protected Delivered delivered;

    public Delivered getDelivered() {
        return delivered;
    }

    public void setDelivered(Delivered delivered) {
        this.delivered = delivered;
    }

    public String getSpecialDeliveryInstructions() {
        return specialDeliveryInstructions;
    }

    public void setSpecialDeliveryInstructions(String specialDeliveryInstructions) {
        this.specialDeliveryInstructions = specialDeliveryInstructions;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public List<DishQuantity> getLines() {
        return lines;
    }

    public void setLines(List<DishQuantity> lines) {
        this.lines = lines;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}