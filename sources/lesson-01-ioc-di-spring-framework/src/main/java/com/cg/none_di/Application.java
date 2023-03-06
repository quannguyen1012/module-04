package com.cg.none_di;

import com.cg.none_di.controller.AboutController;
import com.cg.none_di.controller.ContactController;
import com.cg.none_di.controller.HomeController;

public class Application {

    public static void main(String[] args) {

        HomeController homeController = new HomeController();
        AboutController aboutController = new AboutController();

        //Main -> ContactController -> FacebookService
        // => too much dependency here
        ContactController contactController = new ContactController();

        homeController.send();
        aboutController.send();
        contactController.send();
    }
}
