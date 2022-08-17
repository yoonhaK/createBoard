package com.study.board.domain.post;

import com.study.board.common.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //메서드의 파라미터로 선언된 Model 인터페이스는 데이터를 뷰(HTML)로 전달하는 데 사용
    //게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model){
        if(id != null){
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }

    @PostMapping("/post/save.do")
    public String savePost(PostRequest postRequest, Model model){
        postService.savePost(postRequest);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다", "/post/list.do",
                RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    //게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model){
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        postService.cntPlus(id);
        return "post/view";
    }

    //기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest postRequest, Model model){
        postService.updatePost(postRequest);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다", "/post/list.do",
                RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, Model model){
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다", "/post/list.do",
                RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    //사용자에게 메시지를 전달하고 페이지 리다이렉트 한다
    public String showMessageAndRedirect(final MessageDto params, Model model){
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }

}
