package com.zah.design.strategy.Impl;

import com.zah.design.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component("xiaoMiPayStrategy")
public class XiaoMiPayStrategy implements PayStrategy {
    @Override
    public String toPay() {
        return "使用小米支付。。";
    }
}
