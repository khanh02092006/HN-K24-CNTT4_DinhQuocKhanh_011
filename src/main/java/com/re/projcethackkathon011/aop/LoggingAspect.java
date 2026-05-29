package com.re.projcethackkathon011.aop;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.bookmanager.service.*.*(..))")
    public void logMethod(JoinPoint joinPoint) {
        System.out.println(" MEthod: " + joinPoint.getSignature().getName());
    }
}