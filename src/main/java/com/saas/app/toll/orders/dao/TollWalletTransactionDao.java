package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollWalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TollWalletTransactionDao extends JpaRepository<TollWalletTransaction,Integer> {


}
