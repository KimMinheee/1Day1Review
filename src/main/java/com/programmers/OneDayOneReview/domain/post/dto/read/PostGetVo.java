package com.programmers.OneDayOneReview.domain.post.dto.read;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.programmers.OneDayOneReview.domain.post.domain.Post;
import com.programmers.OneDayOneReview.global.common.domain.BaseStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetVo {
    private Long id;
    private String wellDone1;
    private String wellDone2;
    private String wellDone3;
    private String improvement1;
    private String improvement2;
    private String goal;

    private Long authorId;
    private BaseStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private String createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private String updatedAt;

    public static PostGetVo toDto(Post post) {
        return PostGetVo.builder()
                .id(post.getId())
                .wellDone1(post.getWellDone1())
                .wellDone2(post.getWellDone2())
                .wellDone3(post.getWellDone3())
                .improvement1(post.getImprovement1())
                .improvement2(post.getImprovement2())
                .goal(post.getGoal())
                .authorId(post.getAuthor().getId())
                .status(post.getStatus())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .status(post.getStatus())
                .build();
    }


    @Builder
    public PostGetVo(Long id,
                     String wellDone1,
                     String wellDone2,
                     String wellDone3,
                     String improvement1,
                     String improvement2,
                     String goal,
                     Long authorId,
                     BaseStatus status,
                     String createdAt,
                     String updatedAt) {
        this.id = id;
        this.wellDone1 = wellDone1;
        this.wellDone2 = wellDone2;
        this.wellDone3 = wellDone3;
        this.improvement1 = improvement1;
        this.improvement2 = improvement2;
        this.goal = goal;
        this.authorId = authorId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
