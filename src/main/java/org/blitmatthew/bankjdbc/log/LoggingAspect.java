package org.blitmatthew.bankjdbc.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.blitmatthew.bankjdbc.annotation.*;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Around("@annotation(org.blitmatthew.bankjdbc.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("{}.{} STARTED", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        Object proceed= joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("{} executed in {}ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
