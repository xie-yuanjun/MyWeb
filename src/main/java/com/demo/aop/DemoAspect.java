package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: DemoAspect
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/1313:39
 */
@Aspect
@Component
public class DemoAspect {
    private Logger logger;

    //service
    @Pointcut("execution(public * com.demo.service.*.*(..))")
    public void service() {
    }

    //user
    @Pointcut("execution(public * com.demo.controller.user.*.*(..))")
    public void userController(){}

    //word
    @Pointcut("execution(public * com.demo.controller.word.*.*(..))")
    public void wordController(){}

    //controller
    @Pointcut("userController() || wordController()")
    public void controller(){}

    @Pointcut("controller() || service()")
    public void controllerAndService(){}

    @Before("controllerAndService()")
    public void beforeLog(JoinPoint joinPoint) {
        this.printBeforeLog(joinPoint);
    }

    @AfterReturning(pointcut = "controllerAndService()" +
            "", returning = "returnValue")
    public void afterLog(JoinPoint joinPoint, Object returnValue) {
        this.printAfterReturning(joinPoint, returnValue);
    }

    /**
     * 打印前置日志
     * @param joinPoint
     */
    private void printBeforeLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String methodInfo = this.parseSignature(signature);
        String Parameters = this.parseParams(joinPoint);

        this.logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.debug(methodInfo);
        logger.debug(Parameters);
    }

    /**
     * 打印后置日志
     * @param joinPoint
     * @param returnValue
     */
    private Object printAfterReturning(JoinPoint joinPoint, Object returnValue) {
        Signature signature = joinPoint.getSignature();
        String methodInfo = this.parseSignature(signature);
        this.logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.debug(methodInfo);
        logger.debug(returnValue.toString());
        return returnValue;
    }

    /**
     * 方法签名处理
     * @param signature
     * @return
     */
    private String parseSignature(Signature signature) {
        String info = signature.toString();
        int index1 = info.indexOf(' ') + 1;
        int index2 = info.lastIndexOf('.') + 1;
        StringBuilder str = new StringBuilder();
        str.append(info.substring(0,index1)).append(info.substring(index2));
        return str.toString();
    }
    /**
     * 解析方法参数字符串
     * @param joinPoint
     * @return
     */
    private String parseParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder str = new StringBuilder();
        int length = args.length;
        int beginIndex = 0;
        int endIndex = length - 1;
        if (length == 0) {
            return "()";
        }

        str.append("Parameters: ");
        for (int i = 0; i < length; i++) {
            if (i == beginIndex) {
                str.append(args[i]);
            } else {
                str.append(", ").append(args[i]);
            }
        }
        return str.toString();
    }
}
