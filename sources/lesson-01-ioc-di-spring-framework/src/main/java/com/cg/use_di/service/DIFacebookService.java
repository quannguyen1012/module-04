package com.cg.use_di.service;

public class DIFacebookService implements DIMessageService {

    @Override
    public void sendMessage() {
        System.out.println("Facebook sending...");
    }
}
