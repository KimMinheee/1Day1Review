package com.programmers.OneDayOneReview.domain.postlike.api;

import com.programmers.OneDayOneReview.domain.postlike.service.PostLikeService;
import com.programmers.OneDayOneReview.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.programmers.OneDayOneReview.global.response.SuccessCode.POST_LIKE_SUCCESS;

@RestController
@RequestMapping("/post-like")
@RequiredArgsConstructor
public class PostLikeController {
    private final PostLikeService postLikeService;

    /**
     * 좋아요 추가 or 삭제
     */
    @PostMapping("/{memberId}/{postId}")
    public BaseResponse<String> pushLikeButton(@PathVariable long memberId,
                                               @PathVariable long postId) {

        postLikeService.pushLikeButton(memberId, postId);
        return new BaseResponse<>(POST_LIKE_SUCCESS);
    }
}
