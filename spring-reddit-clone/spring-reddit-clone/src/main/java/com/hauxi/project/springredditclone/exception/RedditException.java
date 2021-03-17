package com.hauxi.project.springredditclone.exception;

public class RedditException extends RuntimeException{

    public RedditException(String exMessage) {
        super(exMessage);
        
    }

    
    public RedditException(String exMessage, Exception e) {
        super(exMessage,e);
        
    }
}
