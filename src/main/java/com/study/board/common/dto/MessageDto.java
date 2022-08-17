package com.study.board.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Getter
@AllArgsConstructor
public class MessageDto {
    private String message; //사용자에게 전달할 메시지
    private String redirectUri;
    //RequestMethod는 spring-web 라이브러리에 포함되어 있는 enum 클래스
    private RequestMethod method; //HTTP 요청메서드
    private Map<String, Object> data; //화면으로 전달할 데이터
}
