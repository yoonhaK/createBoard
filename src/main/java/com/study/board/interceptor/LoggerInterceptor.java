package com.study.board.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로깅 추상화란, 로깅을 직접 하지 않고 로깅 구현체를 찾아 기능을 사용할 수 있게 해주는 것
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

    //컨트롤러에 맵핑된 특정 URI가 호출됐을때 실행되는 메서드, 컨트롤러에 접근하기위해 실행됨
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===============================================");
        log.debug("==================== BEGIN ====================");
        log.debug("Request URI ===> " + request.getRequestURI());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //컨트롤러를 접근한후 화면으로 결과를 전달하기 전에 실행되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("==================== END ====================");
        log.debug("===============================================");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
