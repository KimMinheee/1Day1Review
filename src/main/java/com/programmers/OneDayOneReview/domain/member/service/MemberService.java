package com.programmers.OneDayOneReview.domain.member.service;

import com.programmers.OneDayOneReview.domain.member.dto.MemberCreateRequest;
import com.programmers.OneDayOneReview.domain.member.dto.MemberCreateResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public MemberCreateResponse createMember(MemberCreateRequest memberCreateRequest) {
        return new MemberCreateResponse();
    }
}
