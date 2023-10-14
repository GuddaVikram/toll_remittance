package com.saas.app.toll.orders.dao;

import com.saas.app.toll.orders.entity.TollFastag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TollFastagDao extends JpaRepository<TollFastag, Integer>{
    @Query("SELECT t FROM TollFastag t WHERE t.userId = :userId")
    TollFastag getFastagByUserID(@Param("userId") int userId);

}
