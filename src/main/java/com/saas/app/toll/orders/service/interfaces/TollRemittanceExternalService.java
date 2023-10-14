package com.saas.app.toll.orders.service.interfaces;

import com.saas.app.toll.orders.entity.TollOrder;
import com.saas.app.toll.orders.model.request.TollOrderRequest;
import com.saas.app.toll.orders.model.response.TollOrderResponse;

public interface TollRemittanceExternalService {
    TollOrderResponse createTollRecharge(TollOrderRequest tollOrderRequest, TollOrder tollOrder);
}
