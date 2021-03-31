package com.hauxi.project.springredditclone.mapper;

import com.hauxi.project.springredditclone.dto.SubRedditDto;
import com.hauxi.project.springredditclone.dto.SubRedditDto.SubRedditDtoBuilder;
import com.hauxi.project.springredditclone.model.SubReddit;
import com.hauxi.project.springredditclone.model.SubReddit.SubRedditBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-31T04:29:03+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (AdoptOpenJDK)"
)
@Component
public class SubRedditMapperImpl implements SubRedditMapper {

    @Override
    public SubRedditDto mapSubRedditToDto(SubReddit subReddit) {
        if ( subReddit == null ) {
            return null;
        }

        SubRedditDtoBuilder subRedditDto = SubRedditDto.builder();

        if ( subReddit.getId() != null ) {
            subRedditDto.id( subReddit.getId() );
        }
        subRedditDto.name( subReddit.getName() );
        subRedditDto.description( subReddit.getDescription() );

        subRedditDto.numberOfPosts( mapPosts(subReddit.getPosts()) );

        return subRedditDto.build();
    }

    @Override
    public SubReddit mapDtoToSubReddit(SubRedditDto subRedditDto) {
        if ( subRedditDto == null ) {
            return null;
        }

        SubRedditBuilder subReddit = SubReddit.builder();

        subReddit.id( subRedditDto.getId() );
        subReddit.name( subRedditDto.getName() );
        subReddit.description( subRedditDto.getDescription() );

        return subReddit.build();
    }
}
