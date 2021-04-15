package com.zah.design.context;

import com.zah.design.entity.PaymentChannelEntity;
import com.zah.design.mapper.PaymentChannelMapper;
import com.zah.design.strategy.PayStrategy;
import com.zah.design.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PayContext {

    @Autowired
    private PaymentChannelMapper paymentChannelMapper;


    public String toPayEnumHtml(String payCode) {
        if(StringUtils.isEmpty(payCode)){
            return "payCode不能为空！";
        }
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        if(paymentChannel==null){
            return "查询不到该渠道信息";
        }
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if(strategyBeanId==null){
            return "没有配置策略BeanId";
        }
        PayStrategy payStrategy = SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        return payStrategy.toPay();
    }
}
