package com.programmers.OneDayOneReview.domain.post.service;

import com.programmers.OneDayOneReview.domain.member.domain.Member;
import com.programmers.OneDayOneReview.domain.member.repository.MemberRepository;
import com.programmers.OneDayOneReview.domain.post.domain.Post;
import com.programmers.OneDayOneReview.domain.post.dto.create.PostCreateRequest;
import com.programmers.OneDayOneReview.domain.post.dto.create.PostCreateResponse;
import com.programmers.OneDayOneReview.domain.post.dto.read.PostGetDetailResponse;
import com.programmers.OneDayOneReview.domain.post.dto.read.PostGetResponses;
import com.programmers.OneDayOneReview.domain.post.dto.update.PostUpdateRequest;
import com.programmers.OneDayOneReview.domain.post.repository.PostRepository;
import com.programmers.OneDayOneReview.global.exception.NotFoundException;
import com.programmers.OneDayOneReview.global.exception.PermissionDeniedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.programmers.OneDayOneReview.global.response.ErrorCode.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public PostCreateResponse createPost(long memberId, PostCreateRequest postCreateRequest) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_MEMBER));
        Post post = Post.makePost(
                postCreateRequest.getWellDone1(),
                postCreateRequest.getWellDone2(),
                postCreateRequest.getWellDone3(),
                postCreateRequest.getImprovement1(),
                postCreateRequest.getImprovement2(),
                postCreateRequest.getGoal(),
                member
        );
        postRepository.save(post);
        return PostCreateResponse.toDto(post);
    }

    @Transactional
    public void updatePost(long memberId, long postId, PostUpdateRequest postUpdateRequest) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_MEMBER));

        Post post = postRepository
                .findPostById(postId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_POST));

        if (!member.equals(post.getAuthor())) {
            throw new PermissionDeniedException(PERMISSION_DENIED_UPDATE_POST);
        }

        post.updatePost(
                postUpdateRequest.getWellDone1(),
                postUpdateRequest.getWellDone2(),
                postUpdateRequest.getWellDone3(),
                postUpdateRequest.getImprovement1(),
                postUpdateRequest.getImprovement2(),
                postUpdateRequest.getGoal()
        );
    }

    @Transactional
    public void deletePost(long memberId, long postId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_MEMBER));

        Post post = postRepository
                .findPostById(postId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_POST));

        if (!member.equals(post.getAuthor())) {
            throw new PermissionDeniedException(PERMISSION_DENIED_DELETE_POST);
        }

        post.deletePost();
    }


    public PostGetDetailResponse getPostDetail(long postId) {
        Post post = postRepository
                .findPostById(postId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_POST));
        return PostGetDetailResponse.toDto(post);
    }

    public PostGetResponses getAllPost() {
        List<Post> posts = postRepository
                .findAllPosts();
        return new PostGetResponses(posts);
    }
}
