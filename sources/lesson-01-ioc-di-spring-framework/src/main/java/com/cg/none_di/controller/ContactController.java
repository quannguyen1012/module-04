package com.cg.none_di.controller;

import com.cg.none_di.service.FacebookService;

public class ContactController {

    private FacebookService facebookService = null;

    public ContactController() {
        facebookService = new FacebookService();
    }

    public void send() {
        facebookService.sendMessage();
    }
}
