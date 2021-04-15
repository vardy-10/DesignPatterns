package com.zah.design.strategy.Impl;

import com.zah.design.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component("aliPayStrategy")
public class AlipayStrategy implements PayStrategy {
    @Override
    public String toPay() {
        return "使用alipay支付。。";
    }
}
