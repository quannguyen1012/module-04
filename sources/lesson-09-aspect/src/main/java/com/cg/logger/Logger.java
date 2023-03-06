package com.cg.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    public void error(){
        System.out.println("CMS Error!");
    }

    @AfterThrowing(pointcut = "execution(public * com.cg.service.CustomerService.findAll(..))")
    public void log(JoinPoint joinPoint,Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi say ra : %s.%s%s: %s ", className,method, args,e.getMessage() ));
    }
}
