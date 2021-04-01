package com.hauxi.project.springredditclone.mapper;

import com.hauxi.project.springredditclone.dto.CommentsDto;
import com.hauxi.project.springredditclone.model.Comments;
import com.hauxi.project.springredditclone.model.Comments.CommentsBuilder;
import com.hauxi.project.springredditclone.model.Post;
import com.hauxi.project.springredditclone.model.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-01T10:00:59+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (AdoptOpenJDK)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comments map(CommentsDto commentsDto, Post post, Users user) {
        if ( commentsDto == null && post == null && user == null ) {
            return null;
        }

        CommentsBuilder comments = Comments.builder();

        if ( commentsDto != null ) {
            comments.text( commentsDto.getText() );
        }
        if ( post != null ) {
            comments.post( post );
            comments.user( post.getUser() );
        }
        comments.createdDate( java.time.Instant.now() );

        return comments.build();
    }

    @Override
    public CommentsDto mapToDto(Comments comment) {
        if ( comment == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setCreatedDate( comment.getCreatedDate() );
        commentsDto.setId( comment.getId() );
        commentsDto.setText( comment.getText() );

        commentsDto.setPostId( comment.getPost().getPostId() );
        commentsDto.setUsername( comment.getUser().getUsername() );

        return commentsDto;
    }
}
