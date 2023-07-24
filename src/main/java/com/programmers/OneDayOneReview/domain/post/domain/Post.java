package com.programmers.OneDayOneReview.domain.post.domain;

import com.programmers.OneDayOneReview.domain.member.domain.Member;
import com.programmers.OneDayOneReview.global.common.domain.BaseEntity;
import com.programmers.OneDayOneReview.global.common.domain.BaseStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wellDone1;
    private String wellDone2;
    private String wellDone3;

    private String improvement1;
    private String improvement2;

    private String goal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    public static Post makePost(String wellDone1,
                                String wellDone2,
                                String wellDone3,
                                String improvement1,
                                String improvement2,
                                String goal,
                                Member author) {
        return Post.builder()
                .wellDone1(wellDone1)
                .wellDone2(wellDone2)
                .wellDone3(wellDone3)
                .improvement1(improvement1)
                .improvement2(improvement2)
                .goal(goal)
                .author(author)
                .build();
    }

    public void updatePost(String wellDone1,
                           String wellDone2,
                           String wellDone3,
                           String improvement1,
                           String improvement2,
                           String goal) {
        this.wellDone1 = wellDone1;
        this.wellDone2 = wellDone2;
        this.wellDone3 = wellDone3;
        this.improvement1 = improvement1;
        this.improvement2 = improvement2;
        this.goal = goal;
    }

    public void deletePost() {
        this.changeStatusToInactive();
    }


    private void changeStatusToInactive() {
        super.changeBaseStatus(BaseStatus.INACTIVE);
    }


    @Builder
    public Post(String wellDone1,
                String wellDone2,
                String wellDone3,
                String improvement1,
                String improvement2,
                String goal,
                Member author) {
        this.wellDone1 = wellDone1;
        this.wellDone2 = wellDone2;
        this.wellDone3 = wellDone3;
        this.improvement1 = improvement1;
        this.improvement2 = improvement2;
        this.goal = goal;
        this.author = author;
    }
}
