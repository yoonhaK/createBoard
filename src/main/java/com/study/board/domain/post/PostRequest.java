package com.study.board.domain.post;

import lombok.Getter;
import lombok.Setter;

//클래스 레벨에 선언된 두 어노테이션은 롬복(Lombok) 라이브러리에서 제공해주는 기능으로,
//클래스에 선언된 모든 멤버 변수에 대해 getter와 settter를 생성해주는 역할
@Getter
@Setter
public class PostRequest {
    private Long id; //PK
    private String title;
    private String content; //내용
    private String writer; //작성자
    private Boolean notice_yn; //공지글여부
}
