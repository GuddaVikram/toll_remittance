package com.saas.app.toll.orders.service.implementation;

import com.saas.app.toll.orders.dao.TollWalletDAO;
import com.saas.app.toll.orders.dao.TollWalletTransactionDao;
import com.saas.app.toll.orders.entity.TollOrder;
import com.saas.app.toll.orders.entity.TollWallet;
import com.saas.app.toll.orders.entity.TollWalletTransaction;
import com.saas.app.toll.orders.model.enums.PaymentMode;
import com.saas.app.toll.orders.model.request.TollOrderRequest;
import com.saas.app.toll.orders.model.response.TollOrderResponse;
import com.saas.app.toll.orders.service.interfaces.TollWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TollWalletImpl implements TollWalletService {

    @Autowired
    private TollWalletDAO tollWalletDAO;

    @Autowired
    private TollWalletTransactionDao tollWalletTransactionDao;

    @Autowired
    private TollRechargeHelper tollRechargeHelper;


    @Override
    public TollOrderResponse createTollRecharge(TollOrderRequest tollOrderRequest, TollOrder tollOrder) {

        TollWallet tollWallet = tollWalletDAO.getWalletByUserId(tollOrderRequest.userID);

        if(tollWallet == null){
            throw new IllegalStateException("there is no wallet for the given user");
        }

        tollWalletTransactionDao.save(
                new TollWalletTransaction(
                        tollWallet.getId(),
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
            throw new IllegalStateException("Payment Mode is inValid");

    }


}
