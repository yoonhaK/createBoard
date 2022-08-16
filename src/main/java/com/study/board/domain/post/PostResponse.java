package com.study.board.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id; //PK
    private String title;
    private String content; //내용
    private String writer; //작성자
    private int view_cnt; //조회수
    private Boolean notice_yn; //공지글여부
    private Boolean delete_yn; //삭제 여부
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
}
