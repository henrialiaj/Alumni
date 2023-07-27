package com.example.alumnimanager.posts.service.services;

import com.example.alumnimanager.posts.model.dto.PostDto;
import com.example.alumnimanager.user.model.entity.UserEntity;

import java.util.List;

public interface PostService {

    PostDto getPost(Integer id);

    PostDto createPost(PostDto postDto);

    PostDto createEvent(PostDto postDto);

    List<PostDto> findPostsByUser(Integer id);

    List<PostDto> AllEvents();

    PostDto updatePost(Integer id, PostDto postDto);

    PostDto updateEvent(Integer id, PostDto postDto);

    void delete(Integer id);
}
