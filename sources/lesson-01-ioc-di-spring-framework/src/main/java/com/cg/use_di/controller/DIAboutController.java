package com.cg.use_di.controller;

import com.cg.use_di.service.DIMessageService;

public class DIAboutController {

    private DIMessageService messageService;

    public DIAboutController(DIMessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage();
    }
}
