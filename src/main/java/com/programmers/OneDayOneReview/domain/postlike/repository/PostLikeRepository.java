package com.programmers.OneDayOneReview.domain.postlike.repository;

import com.programmers.OneDayOneReview.domain.postlike.domain.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    @Query("select pl from PostLike pl where pl.status = 'ACTIVE' and pl.member.id = :memberId and pl.post.id = :postId")
    Optional<PostLike> findPostLikeByMemberIdAndPostId(long memberId, long postId);

    @Modifying
    @Query("update PostLike pl set pl.status = 'INACTIVE' where pl.id = :postLikeId")
    void deletePostLikeById(long postLikeId);
}
