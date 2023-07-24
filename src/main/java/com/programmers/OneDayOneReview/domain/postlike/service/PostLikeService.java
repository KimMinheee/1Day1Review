package com.programmers.OneDayOneReview.domain.postlike.service;

import com.programmers.OneDayOneReview.domain.member.domain.Member;
import com.programmers.OneDayOneReview.domain.member.repository.MemberRepository;
import com.programmers.OneDayOneReview.domain.post.domain.Post;
import com.programmers.OneDayOneReview.domain.post.repository.PostRepository;
import com.programmers.OneDayOneReview.domain.postlike.domain.PostLike;
import com.programmers.OneDayOneReview.domain.postlike.repository.PostLikeRepository;
import com.programmers.OneDayOneReview.global.exception.NotFoundException;
import com.programmers.OneDayOneReview.global.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    /**
     * 좋아요 기능
     * case1. 이미 존재한다면 존재하는 좋아요 취소
     * case2. 존재하지 않는다면 좋아요 추가
     */
    @Transactional
    public void pushLikeButton(long memberId, long postId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_MEMBER));

        postLikeRepository.findPostLikeByMemberIdAndPostId(memberId, postId)
                .ifPresentOrElse(
                        postLike -> postLikeRepository.deletePostLikeById(postLike.getId()),
                        () -> {
                            Post post = postRepository.findPostById(postId).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_POST));
                            postLikeRepository.save(new PostLike(member, post));
                        });
    }
}
