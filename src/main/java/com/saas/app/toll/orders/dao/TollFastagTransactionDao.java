package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollFastagTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TollFastagTransactionDao extends JpaRepository<TollFastagTransaction,Integer> {
}
