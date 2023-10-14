package com.saas.app.toll.orders.entity;


import com.saas.app.toll.orders.model.enums.RechargeType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "toll_orders")
@NoArgsConstructor
public class TollOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private RechargeType orderType;
    private String status;

    private BigDecimal amount;
    private String currency;
    private Boolean isDiscountApplicable;
    private BigDecimal marginPercentage;
    private UUID createdBy;
    private UUID updatedBy;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    public TollOrder(int userId, RechargeType orderType, String status, BigDecimal amount, Boolean isDiscountApplicable, BigDecimal marginPercentage,String currency) {
        this.userId = userId;
        this.orderType = orderType;
        this.status = status;
        this.amount = amount;
        this.isDiscountApplicable = isDiscountApplicable;
        this.marginPercentage = marginPercentage;
        this.currency = currency;
    }

    public int getId() { return id; }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public RechargeType getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = RechargeType.valueOf(orderType);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDiscountApplicable() {
        return isDiscountApplicable;
    }

    public void setDiscountApplicable(Boolean discountApplicable) {
        isDiscountApplicable = discountApplicable;
    }

    public BigDecimal getMarginPercentage() {
        return marginPercentage;
    }

    public void setMarginPercentage(BigDecimal marginPercentage) {
        this.marginPercentage = marginPercentage;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }
}
