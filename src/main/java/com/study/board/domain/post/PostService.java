package com.study.board.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor //롬복(Lombok)에서 제공해주는 기능으로,
//클래스 내에 final로 선언된 모든 멤버에 대한 생성자를 만들어주는 역할
public class PostService {
    private final PostMapper postMapper;;

    /**
     * save post
     * @param postRequest
     * @return generated PK
     */
    //해당 어노테이션이 선언된 메서드가 호출되면 트랜잭션이 시작되고,
    //메서드의 정상 종료 여부에 따라 Commit 또는 Rollback 됩니다.
    @Transactional
    public Long savePost(final PostRequest postRequest){
        postMapper.save(postRequest);
        return postRequest.getId();
    }

    /**
     * 게시글 상세 정보 조회
     * @param id
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final Long id){
        return postMapper.findById(id);
    }

    /**
     * update post
     * @param postRequest
     * @return PK
     */
    public Long updatePost(final PostRequest postRequest){
        postMapper.update(postRequest);
        return postRequest.getId();
    }

    public Long deletePost(final Long id){
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @return list of posts
     */
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }

    public boolean cntPlus(Long id){
        return postMapper.cntPlus(id);
    }
}
