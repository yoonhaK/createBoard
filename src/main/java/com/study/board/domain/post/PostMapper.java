package com.study.board.domain.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//MyBatis는 인터페이스에 @Mapper만 선언해주면,
//XML Mapper에서 메서드의 이름과 일치하는 SQL 문을 찾아 실행
@Mapper
public interface PostMapper {
    /**
     * 게시글 저장
     * @param postRequest 게시글 정보
     */
    void save(PostRequest postRequest);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * return 게시글 상세정보
     */
    PostResponse findById(Long id);

    /**
     * 게시글수정
     * @param postRequest
     */
    void update(PostRequest postRequest);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();

    boolean cntPlus(Long id);
}
