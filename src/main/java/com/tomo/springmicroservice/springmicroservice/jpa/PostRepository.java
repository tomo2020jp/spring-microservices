package com.tomo.springmicroservice.springmicroservice.jpa;

import com.tomo.springmicroservice.springmicroservice.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
