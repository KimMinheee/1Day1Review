package com.programmers.OneDayOneReview.domain.post.dto.read;

import com.programmers.OneDayOneReview.domain.post.domain.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostGetResponses {
    private List<PostGetVo> responses;

    public PostGetResponses(List<Post> posts) {
        this.responses = posts
                .stream()
                .map(PostGetVo::toDto)
                .collect(Collectors.toList());
    }
}
