package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollOrder;

import  java.util.List;

public interface TollOrderDAO {
    void save(TollOrder tollOrder);

    TollOrder findById(Integer id);

    List<TollOrder> listOrdersByUserId(Integer userId);

    void updateOrderStatus(String orderStatus, Integer id);
}
