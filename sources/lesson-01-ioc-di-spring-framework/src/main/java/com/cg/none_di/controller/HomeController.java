package com.cg.none_di.controller;

import com.cg.none_di.service.SmsService;

public class HomeController {

    private SmsService smsService = null;

    public HomeController() {
        smsService = new SmsService();
    }

    public void send() {
        smsService.sendMessage();
    }
}
