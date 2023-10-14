package com.saas.app.toll.orders.entity;


import com.saas.app.toll.orders.model.enums.PaymentMode;
import com.saas.app.toll.orders.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "toll_wallet_transactions")
@Getter
@Setter
public class TollWalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int walletId;
    private int tollOrderId;
    private BigDecimal amount;
    private String status;
    private PaymentMode paymentMode;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private Timestamp updatedAst = Timestamp.from(Instant.now());

    public TollWalletTransaction(int walletId, int tollOrderId, BigDecimal amount, String status, PaymentMode paymentMode) {
        this.walletId = walletId;
        this.tollOrderId = tollOrderId;
        this.amount = amount;
        this.status = status;
        this.paymentMode = paymentMode;
    }
}
