package com.programmers.OneDayOneReview.domain.post.dto.create;

import com.programmers.OneDayOneReview.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostCreateResponse {
    private final Long id;
    private final String wellDone1;
    private final String wellDone2;
    private final String wellDone3;
    private final String improvement1;
    private final String improvement2;
    private final String goal;

    private final Long authorId;

    @Builder
    private PostCreateResponse(Long id,
                               String wellDone1,
                               String wellDone2,
                               String wellDone3,
                               String improvement1,
                               String improvement2,
                               String goal,
                               Long authorId) {
        this.id = id;
        this.wellDone1 = wellDone1;
        this.wellDone2 = wellDone2;
        this.wellDone3 = wellDone3;
        this.improvement1 = improvement1;
        this.improvement2 = improvement2;
        this.goal = goal;
        this.authorId = authorId;
    }

    public static PostCreateResponse toDto(Post post) {
        return PostCreateResponse.builder()
                .id(post.getId())
                .wellDone1(post.getWellDone1())
                .wellDone2(post.getWellDone2())
                .wellDone3(post.getWellDone3())
                .improvement1(post.getImprovement1())
                .improvement2(post.getImprovement2())
                .goal(post.getGoal())
                .authorId(post.getAuthor().getId())
                .build();
    }
}
