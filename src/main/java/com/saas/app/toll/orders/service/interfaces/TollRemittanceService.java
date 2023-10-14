package com.saas.app.toll.orders.service.interfaces;

import com.saas.app.toll.orders.model.request.TollOrderRequest;
import com.saas.app.toll.orders.model.response.TollOrderResponse;

public interface TollRemittanceService {
    TollOrderResponse createTollOrder(TollOrderRequest tollOrderRequest);
}
