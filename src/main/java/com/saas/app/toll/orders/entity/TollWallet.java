package com.saas.app.toll.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "toll_wallets")
@Getter
@Setter
public class TollWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private BigDecimal balance;
    private String status;
    private Timestamp lastTransactionAt;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    public TollWallet(int userId, BigDecimal balance, String status) {
        this.userId = userId;
        this.balance = balance;
        this.status = status;
    }
}
