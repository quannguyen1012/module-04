package com.cg.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

import java.util.Arrays;

public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.cg.service.customer.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] xay ra van de: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
