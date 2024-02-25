package ru.gb.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
//@Component
public class TimeAspect {

    @Pointcut("@annotation(ru.gb.utils.Timer)||@within(ru.gb.utils.Timer)")
    public void timerPointcut() {
    }

    @Around("timerPointcut()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long executionTime = System.nanoTime() - start;
        double seconds = (double) executionTime/1_000_000_000;

        log.info(String.format("КУКУ%s - %s - %s", className, methodName, seconds));
        return proceed;
    }
}
