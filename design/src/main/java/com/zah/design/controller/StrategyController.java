package com.zah.design.controller;

import com.zah.design.context.PayContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {
    @Autowired
    private PayContext payContext;

    @RequestMapping("/pay")
    public  String pay(String payCode){
       return  payContext.toPayEnumHtml(payCode);
    }
}
