package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TollOrderDAOImpl implements TollOrderDAO{
    private EntityManager entityManager;

    @Autowired
    public TollOrderDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(TollOrder tollOrder){
        entityManager.persist(tollOrder);
    }

    @Override
    public TollOrder findById(Integer id){
        return entityManager.find(TollOrder.class, id);
    }

    @Override
    public List<TollOrder> listOrdersByUserId(Integer userId) {
        TypedQuery<TollOrder> query = entityManager.createQuery("FROM TollOrder where userId= :userId", TollOrder.class);

        query.setParameter("userId",userId);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateOrderStatus(String orderStatus, Integer id) {
        TollOrder tollOrder = entityManager.find(TollOrder.class, id);

        tollOrder.setStatus(orderStatus);

        entityManager.merge(tollOrder);
    }




}
