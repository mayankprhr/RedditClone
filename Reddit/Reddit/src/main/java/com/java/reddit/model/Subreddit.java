package com.java.reddit.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;
import java.time.Instant;
import java.util.List;


public class Subreddit {    
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;

    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    private Instant createdDate;
    
    @ManyToOne(fetch=LAZY)
    private User user;
}
