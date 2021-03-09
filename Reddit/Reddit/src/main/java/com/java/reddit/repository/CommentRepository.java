package com.java.reddit.repository;

import com.java.reddit.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CommentRepository
 */

 @Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
    
}