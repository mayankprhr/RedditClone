package com.hauxi.project.springredditclone.mapper;

import com.hauxi.project.springredditclone.dto.SubRedditDto;
import com.hauxi.project.springredditclone.dto.SubRedditDto.SubRedditDtoBuilder;
import com.hauxi.project.springredditclone.model.SubReddit;
import com.hauxi.project.springredditclone.model.SubReddit.SubRedditBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-02T01:49:15+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (AdoptOpenJDK)"
)
@Component
public class SubRedditMapperImpl implements SubRedditMapper {

    @Override
    public SubRedditDto mapSubRedditToDto(SubReddit subReddit) {
        if ( subReddit == null ) {
            return null;
        }

        SubRedditDtoBuilder subRedditDto = SubRedditDto.builder();

        subRedditDto.description( subReddit.getDescription() );
        if ( subReddit.getId() != null ) {
            subRedditDto.id( subReddit.getId() );
        }
        subRedditDto.name( subReddit.getName() );

        subRedditDto.numberOfPosts( mapPosts(subReddit.getPosts()) );

        return subRedditDto.build();
    }

    @Override
    public SubReddit mapDtoToSubReddit(SubRedditDto subRedditDto) {
        if ( subRedditDto == null ) {
            return null;
        }

        SubRedditBuilder subReddit = SubReddit.builder();

        subReddit.description( subRedditDto.getDescription() );
        subReddit.id( subRedditDto.getId() );
        subReddit.name( subRedditDto.getName() );

        return subReddit.build();
    }
}
