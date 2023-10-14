package com.saas.app.toll.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "toll_fastags")
@Getter
@Setter
public class TollFastag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String fastagNumber;
    private String vehicleNumer;
    private BigDecimal currentBalance;
    private String issuerBank;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private  Timestamp updatedAt = Timestamp.from(Instant.now());

    public TollFastag(int userId, String fastagNumber, String vehicleNumer, BigDecimal currentBalance, String issuerBank) {
        this.userId = userId;
        this.fastagNumber = fastagNumber;
        this.vehicleNumer = vehicleNumer;
        this.currentBalance = currentBalance;
        this.issuerBank = issuerBank;
    }
}

