package com.saas.app.toll.orders.model.request;

import com.saas.app.toll.orders.model.enums.RechargeType;
import com.saas.app.toll.orders.model.enums.PaymentMode;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TollOrderRequest {
    @NotNull(message = "userId is mandatory")
    public int userID;
    public RechargeType tollRechargeType;
    public PaymentMode tollPaymentMode;
    public BigDecimal marginPercentage;
    public Boolean isDiscountApplicable;
    public BigDecimal amount;
    public String transactionReferenceNo;
    public String tollPaymentMethod;
    public String currency;
    public String bankName;
    public String vehicleRegNo;
}
