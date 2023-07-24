package com.programmers.OneDayOneReview.domain.post.dto.create;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostCreateRequest {
    private final String wellDone1;
    private final String wellDone2;
    private final String wellDone3;

    private final String improvement1;
    private final String improvement2;

    private final String goal;
}
