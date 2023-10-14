package com.saas.app.toll.orders.service.implementation;

import com.saas.app.toll.orders.model.enums.RechargeType;
import com.saas.app.toll.orders.service.interfaces.TollFastagService;
import com.saas.app.toll.orders.service.interfaces.TollRemittanceExternalService;
import com.saas.app.toll.orders.service.interfaces.TollWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TollResolverFactory {
    @Autowired
    public TollFastagService tollFastagService;

    @Autowired
    public TollWalletService tollWalletService;

    TollRemittanceExternalService getOrderType(RechargeType rechargeType){
        if(rechargeType  == RechargeType.FASTAG_RECHARGE)
            return tollFastagService;
        else if(rechargeType == RechargeType.WALLET_RECHARGE)
            return tollWalletService;
        else{
            return null;
        }
    }
}
