package com.udacity.data.repository;

import com.udacity.data.entity.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryDAOImpl implements DeliveryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    @Override
    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Override
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    @Override
    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
