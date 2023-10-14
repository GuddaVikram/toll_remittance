package com.saas.app.toll.orders.service.implementation;


import com.saas.app.toll.orders.dao.TollOrderDAO;
import com.saas.app.toll.orders.entity.TollOrder;
import com.saas.app.toll.orders.model.enums.RechargeType;
import com.saas.app.toll.orders.model.enums.PaymentMode;
import com.saas.app.toll.orders.model.request.TollOrderRequest;
import com.saas.app.toll.orders.model.response.TollOrderResponse;
import com.saas.app.toll.orders.service.interfaces.TollRemittanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TollRemittanceServiceImpl implements TollRemittanceService {

    @Autowired
    private TollOrderDAO tollOrderDAO;

    @Autowired
    private TollResolverFactory tollResolverFactory;

    @Override
    public TollOrderResponse createTollOrder(TollOrderRequest tollOrderRequest) {
        validateOrderRequest(tollOrderRequest);
        TollOrder tollOrder = createTollOrderReq(tollOrderRequest);

        tollOrderDAO.save(tollOrder);

        return tollResolverFactory.
                getOrderType(tollOrderRequest.tollRechargeType).
                    createTollRecharge(tollOrderRequest,tollOrder);
    }

    private void validateOrderRequest(TollOrderRequest tollOrderRequest){
        if(tollOrderRequest.tollRechargeType == RechargeType.FASTAG_RECHARGE){
            if(tollOrderRequest.vehicleRegNo.isEmpty() || tollOrderRequest.bankName == null)
                throw new IllegalStateException();
        }
        if(tollOrderRequest.tollPaymentMode == PaymentMode.OFF_PLATFORM){
            if(tollOrderRequest.transactionReferenceNo.isEmpty() || tollOrderRequest.tollPaymentMethod.isEmpty())
                throw new IllegalStateException();
        }
    }

    private TollOrder createTollOrderReq(TollOrderRequest tollOrderRequest){
        return new TollOrder(
            tollOrderRequest.userID,
                tollOrderRequest.tollRechargeType,
                "created", tollOrderRequest.amount, tollOrderRequest.isDiscountApplicable,
                tollOrderRequest.marginPercentage,
                tollOrderRequest.currency
        );
    }



}
