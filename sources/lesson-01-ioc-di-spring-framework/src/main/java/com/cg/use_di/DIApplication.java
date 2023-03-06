package com.cg.use_di;

import com.cg.use_di.controller.DIAboutController;
import com.cg.use_di.controller.DIContactController;
import com.cg.use_di.controller.DIHomeController;
import com.cg.use_di.service.DIEmailService;
import com.cg.use_di.service.DIFacebookService;
import com.cg.use_di.service.DIMessageService;
import com.cg.use_di.service.DISmsService;

public class DIApplication {

    public static void main(String[] args) {

        //We saw: Controller and Service do not dependent on each others
        //If we have edit something at Controller or Service will not effect each others
        //Just edit at MessageService will be okay => less dependency
        DIMessageService diEmailService = new DIEmailService();
        DIMessageService diFacebookService = new DIFacebookService();
        DIMessageService diSmsService = new DISmsService();

        DIHomeController diHomeController = new DIHomeController(diEmailService);
        DIAboutController diAboutController = new DIAboutController(diFacebookService);
        DIContactController diContactController = new DIContactController(diSmsService);

        diHomeController.send();
        diAboutController.send();
        diContactController.send();
    }
}
