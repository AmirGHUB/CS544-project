package edu.miu.cs544.team6.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* edu.miu.cs544.team6.controller.*.*(..))) && execution(* edu.miu.cs544.team6.service.*.*(..)))")
    public Object logMethodTiming(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logExecutionTime(className, methodName, stopWatch);
        return result;
    }

    private void logExecutionTime(String className, String methodName, StopWatch stopWatch) {
        LOGGER.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
