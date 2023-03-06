package com.cg.none_di.controller;

import com.cg.none_di.service.EmailService;

public class AboutController {

    private EmailService emailService = null;

    public AboutController() {
        emailService = new EmailService();
    }

    public void send() {
        emailService.sendMessage();
    }
}
