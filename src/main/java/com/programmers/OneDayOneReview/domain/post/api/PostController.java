package com.programmers.OneDayOneReview.domain.post.api;

import com.programmers.OneDayOneReview.domain.post.dto.create.PostCreateRequest;
import com.programmers.OneDayOneReview.domain.post.dto.create.PostCreateResponse;
import com.programmers.OneDayOneReview.domain.post.dto.read.PostGetDetailResponse;
import com.programmers.OneDayOneReview.domain.post.dto.read.PostGetResponses;
import com.programmers.OneDayOneReview.domain.post.dto.update.PostUpdateRequest;
import com.programmers.OneDayOneReview.domain.post.service.PostService;
import com.programmers.OneDayOneReview.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.programmers.OneDayOneReview.global.response.SuccessCode.UPDATE_POST_SUCCESS;

/**
 * 1. 글 작성
 * 2. 글 수정
 * 3. 글 삭제
 * 4. 전체 글 조회(여러명의 글 존재)
 * 6. 특정 글 조회
 */
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /**
     * 글 작성
     *
     * @param memberId
     * @param postCreateRequest
     * @return BaseResponse<PostCreateResponse>
     */
    @PostMapping()
    public BaseResponse<PostCreateResponse> createPost(@RequestParam long memberId,
                                                       @RequestBody PostCreateRequest postCreateRequest) {
        PostCreateResponse response = postService.createPost(memberId, postCreateRequest);
        return new BaseResponse<>(response);
    }

    /**
     * 글 수정
     *
     * @param memberId
     * @param postId
     * @param postUpdateRequest
     * @return
     */
    @PutMapping("/{memberId}/{postId}")
    public BaseResponse<String> updatePost(@PathVariable long memberId,
                                           @PathVariable long postId,
                                           @RequestBody PostUpdateRequest postUpdateRequest) {

        postService.updatePost(memberId, postId, postUpdateRequest);
        return new BaseResponse<>(UPDATE_POST_SUCCESS);
    }

    /**
     * 글 삭제
     */
    @DeleteMapping("/{memberId}/{postId}")
    public BaseResponse<String> deletePost(@PathVariable long memberId,
                                           @PathVariable long postId) {

        postService.deletePost(memberId, postId);
        return new BaseResponse<>(UPDATE_POST_SUCCESS);
    }

    /**
     * 특정 글 조회
     */
    @GetMapping("/{postId}")
    public BaseResponse<PostGetDetailResponse> getPostDetailById(@PathVariable long postId) {
        PostGetDetailResponse response = postService.getPostDetail(postId);
        return new BaseResponse<>(response);
    }


    /**
     * 전체 게시글 조회
     */
    @GetMapping()
    public BaseResponse<PostGetResponses> getAllPost() {

        PostGetResponses responses = postService.getAllPost();
        return new BaseResponse<>(responses);
    }

}
