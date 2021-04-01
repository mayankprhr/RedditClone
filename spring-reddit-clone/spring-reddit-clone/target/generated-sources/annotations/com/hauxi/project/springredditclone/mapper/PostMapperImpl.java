package com.hauxi.project.springredditclone.mapper;

import com.hauxi.project.springredditclone.dto.PostRequest;
import com.hauxi.project.springredditclone.dto.PostResponse;
import com.hauxi.project.springredditclone.model.Post;
import com.hauxi.project.springredditclone.model.Post.PostBuilder;
import com.hauxi.project.springredditclone.model.SubReddit;
import com.hauxi.project.springredditclone.model.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-02T01:49:16+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (AdoptOpenJDK)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post map(PostRequest postRequest, SubReddit subReddit, Users user) {
        if ( postRequest == null && subReddit == null && user == null ) {
            return null;
        }

        PostBuilder post = Post.builder();

        if ( postRequest != null ) {
            post.description( postRequest.getDescription() );
            post.postId( postRequest.getPostId() );
            post.postName( postRequest.getPostName() );
            post.url( postRequest.getUrl() );
        }
        if ( subReddit != null ) {
            post.subReddit( subReddit );
        }
        if ( user != null ) {
            post.user( user );
        }
        post.createDate( (java.time.Instant.now()) );

        return post.build();
    }

    @Override
    public PostResponse mapToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.setId( post.getPostId() );
        postResponse.setPostName( post.getPostName() );
        postResponse.setDescription( post.getDescription() );
        postResponse.setUrl( post.getUrl() );
        postResponse.setSubRedditName( postSubRedditName( post ) );
        postResponse.setUsername( postUserUsername( post ) );

        return postResponse;
    }

    private String postSubRedditName(Post post) {
        if ( post == null ) {
            return null;
        }
        SubReddit subReddit = post.getSubReddit();
        if ( subReddit == null ) {
            return null;
        }
        String name = subReddit.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String postUserUsername(Post post) {
        if ( post == null ) {
            return null;
        }
        Users user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
