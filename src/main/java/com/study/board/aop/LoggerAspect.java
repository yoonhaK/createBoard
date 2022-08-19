package com.study.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect //AOP 기능을 하는 클래스의 클래스 레벨에 지정하는 어노테이션
@Component
public class LoggerAspect {

    //@Around
    //어드바이스(Advice)의 종류 중 한 가지로 어드바이스는 모두 다섯 가지의 타입이 있습니다.
    //다섯 가지 중 어라운드(Around)는 메서드의 호출 자체를 제어할 수 있기 때문에
    //어드바이스 중 가장 강력한 기능
    //execution
    //접근 제어자, 리턴 타입, 타입 패턴, 메서드, 파라미터 타입, 예외 타입 등을 조합해서
    //정교한 포인트컷을 만들 수 있습니다.
    //ex 해당 패키지 밑에 파라미터가 0개 이상인 모든 메서드가 호출될 때
    @Around("execution(* com.study.board.domain..*Controller.*(..)) || " +
            "execution(* com.study.board.domain..*Service.*(..)) || " +
            "execution(* com.study.board.domain..*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable{
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String type = "";

        if(name.contains("Controller")){
            type = "Controller ===> ";
        }
        else if(name.contains("Service")){
            type = "Service ===> ";
        }
        else if(name.contains("Mapper")){
            type = "Mapper ===> ";
        }
        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }

}
