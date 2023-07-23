package com.programmers.OneDayOneReview.domain.member.repository;

import com.programmers.OneDayOneReview.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
