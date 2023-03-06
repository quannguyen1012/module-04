package com.cg.use_di.controller;

import com.cg.use_di.service.DIMessageService;

public class DIHomeController {

    private DIMessageService messageService;

    //Constructor Injection
    public DIHomeController(DIMessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage();
    }
}
