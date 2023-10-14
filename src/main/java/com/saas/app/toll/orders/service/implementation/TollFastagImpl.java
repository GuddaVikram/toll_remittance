package com.saas.app.toll.orders.service.implementation;

import com.saas.app.toll.orders.dao.TollFastagDao;
import com.saas.app.toll.orders.dao.TollFastagTransactionDao;
import com.saas.app.toll.orders.entity.TollFastag;
import com.saas.app.toll.orders.entity.TollFastagTransaction;
import com.saas.app.toll.orders.entity.TollOrder;
import com.saas.app.toll.orders.model.enums.PaymentMode;
import com.saas.app.toll.orders.model.request.TollOrderRequest;
import com.saas.app.toll.orders.model.response.TollOrderResponse;
import com.saas.app.toll.orders.service.interfaces.TollFastagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TollFastagImpl implements TollFastagService {

    @Autowired
    private TollFastagDao tollFastagDao;

    @Autowired
    private TollFastagTransactionDao tollFastagTransactionDao;

    @Autowired
    private TollRechargeHelper tollRechargeHelper;

    @Override
    public TollOrderResponse createTollRecharge(TollOrderRequest tollOrderRequest, TollOrder tollOrder) {
        // check if fastag is present or not if not throw an error
        // create a fastag transaction as created and handle cases

        TollFastag tollFastag = tollFastagDao.getFastagByUserID(tollOrder.getUserId());

        if(tollFastag == null){
            throw new IllegalStateException("No fastag account associated with user");
        }

        tollFastagTransactionDao.save(
                new TollFastagTransaction(
                        tollFastag.getId(),
                        tollOrder.getId(),
                        tollOrderRequest.amount,
                        "CREATED",
                        tollOrderRequest.tollPaymentMode
                )
        );

        if(tollOrderRequest.tollPaymentMode == PaymentMode.ON_PLATFORM)
            return tollRechargeHelper.OnPlatformPayment();
        else if(tollOrderRequest.tollPaymentMode == PaymentMode.OFF_PLATFORM)
            return tollRechargeHelper.OffPlatformPayment();
        else
            return  tollRechargeHelper.WalletPayment();

    }
}
