package com.study.board.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostMapperTest {

    @Autowired
    PostMapper postMapper;

//    @Test
//    void save(){
//        PostRequest postRequest = new PostRequest();
//        postRequest.setTitle("testTitle");
//        postRequest.setContent("test Content");
//        postRequest.setWriter("tester");
//        postRequest.setNotice_yn(false);
//        postMapper.save(postRequest);
//
//        List<PostResponse> posts = postMapper.findAll();
//        //assertThat(posts.size()).isEqualTo(1);
//    }
//
//    @Test
//    void findById(){
//        PostResponse post = postMapper.findById(1L);
//        assertThat(post).isNotNull();
//    }
//
//    @Test
//    void update(){
//        PostRequest postRequest = new PostRequest();
//        postRequest.setId(1L);
//        postRequest.setTitle("update post");
//        postRequest.setContent("update post content");
//        postRequest.setWriter("tester2");
//        postRequest.setNotice_yn(false);
//        postMapper.update(postRequest);
//
//        PostResponse post = postMapper.findById(1L);
//        assertThat(post.getWriter()).isEqualTo("tester2");
//    }
//
//    @Test
//    void delete(){
//        postMapper.deleteById(1L);
//    }
}