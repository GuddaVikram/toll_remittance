package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TollWalletDAO extends JpaRepository<TollWallet, Integer> {

    @Query("SELECT t FROM TollWallet t WHERE t.userId = :userId")
    TollWallet getWalletByUserId(@Param("userId") int userId);


}
