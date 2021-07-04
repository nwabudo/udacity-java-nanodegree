package com.udacity.data.repository;

import com.udacity.data.entity.Delivery;

public interface DeliveryDAO {

    void persist(Delivery delivery);

    Delivery find(Long id);

    Delivery merge(Delivery delivery);

    void delete(Long id);
}
