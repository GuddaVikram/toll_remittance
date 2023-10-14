package com.saas.app.toll.orders.entity;

import com.saas.app.toll.orders.model.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "toll_fastag_transactions")
@Getter
@Setter
public class TollFastagTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fastagId;
    private int tollOrderId;
    private BigDecimal amount;
    private String status;
    private PaymentMode paymentMode;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    public TollFastagTransaction(int fastagId, int tollOrderId, BigDecimal amount, String status, PaymentMode paymentMode) {
        this.fastagId = fastagId;
        this.tollOrderId = tollOrderId;
        this.amount = amount;
        this.status = status;
        this.paymentMode = paymentMode;
    }
}
