package com.udacity.jdnd.course1.entity;

import java.util.List;

public class Order {
    private Integer id;
    private Customer customer;
    private List<TacoOrder> tacoOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<TacoOrder> getTacoOrders() {
        return tacoOrders;
    }

    public void setTacoOrders(List<TacoOrder> tacoOrders) {
        this.tacoOrders = tacoOrders;
    }
}
