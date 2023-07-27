package com.example.alumnimanager.posts.service.mapper;

import com.example.alumnimanager.posts.model.dto.PostDto;
import com.example.alumnimanager.posts.model.entity.PostEntity;
import com.example.alumnimanager.user.service.mapper.UserConverter;

public class PostConverter {

    public static PostDto convertPostEntityToDto(PostEntity postEntity){
        PostDto postDto = new PostDto();

        postDto.setId(postEntity.getId());
        postDto.setUser(postEntity.getUser().getUser_id());
        postDto.setContent(postEntity.getContent());
        postDto.setPictureUrl(postEntity.getPictureUrl());
        postDto.setTime(postEntity.getTime());
        postDto.setEventTime(postEntity.getEventTime());

        return postDto;
    }
}
