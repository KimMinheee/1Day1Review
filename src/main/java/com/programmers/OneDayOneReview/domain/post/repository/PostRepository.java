package com.programmers.OneDayOneReview.domain.post.repository;

import com.programmers.OneDayOneReview.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.id = :postId and p.status = 'ACTIVE'")
    Optional<Post> findPostById(long postId);

    @Query("select p from Post p where p.status = 'ACTIVE'")
    List<Post> findAllPosts();
}
