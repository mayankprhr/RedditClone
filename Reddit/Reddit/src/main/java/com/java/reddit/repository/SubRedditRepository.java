package com.java.reddit.repository;

import com.java.reddit.model.Subreddit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRedditRepository extends JpaRepository<Subreddit,Long>{
    
}