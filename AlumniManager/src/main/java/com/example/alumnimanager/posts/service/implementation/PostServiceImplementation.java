package com.example.alumnimanager.posts.service.implementation;

import com.example.alumnimanager.posts.model.dto.PostDto;
import com.example.alumnimanager.posts.model.entity.PostEntity;
import com.example.alumnimanager.posts.model.enums.PostType;
import com.example.alumnimanager.posts.repository.PostRepository;
import com.example.alumnimanager.posts.service.mapper.PostConverter;
import com.example.alumnimanager.posts.service.services.PostService;
import com.example.alumnimanager.user.model.entity.UserEntity;
import com.example.alumnimanager.user.repository.UserRepository;
import com.example.alumnimanager.user.service.mapper.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public PostDto getPost(Integer id) {
        if (postRepository.findById(id).isPresent()
                && postRepository.findById(id).get().getType().equals(PostType.POST)){
            return PostConverter.convertPostEntityToDto(postRepository.findById(id).get());
        }
        return new PostDto();
    }

    @Override
    public List<PostDto> findPostsByUser(Integer id) {
        return postRepository.findAll()
                .stream()
                .filter(postEntity -> postEntity.getUser().getUser_id().equals(id)
                && postEntity.getType().equals(PostType.POST))
                .map(PostConverter::convertPostEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        UserEntity user = userRepository.findById(postDto.getUser()).get();
        postEntity.setId(postDto.getId());
        postEntity.setUser(user);
        postEntity.setContent(postDto.getContent());
        postEntity.setPictureUrl(postDto.getPictureUrl());
        postEntity.setType(PostType.POST);
        postEntity.setTime(postDto.getTime());
        postEntity.setEventTime(postDto.getEventTime());

        postRepository.save(postEntity);

        return PostConverter.convertPostEntityToDto(postEntity);
    }

    @Override
    public PostDto createEvent(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        UserEntity user = userRepository.findById(postDto.getUser()).get();
        postEntity.setId(postDto.getId());
        postEntity.setUser(user);
        postEntity.setContent(postDto.getContent());
        postEntity.setPictureUrl(postDto.getPictureUrl());
        postEntity.setType(PostType.EVENT);
        postEntity.setTime(postDto.getTime());
        postEntity.setEventTime(postDto.getEventTime());

        return PostConverter.convertPostEntityToDto(postEntity);
    }

    @Override
    public List<PostDto> AllEvents() {
        return postRepository.findAll()
                .stream()
                .filter(postEntity -> postEntity.getType().equals(PostType.EVENT))
                .map(PostConverter::convertPostEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Integer id, PostDto postDto) {
        PostEntity postEntity = postRepository.findById(id).get();
        UserEntity user = userRepository.findById(postDto.getUser()).get();
        postEntity.setId(postDto.getId());
        postEntity.setUser(user);
        postEntity.setContent(postDto.getContent());
        postEntity.setPictureUrl(postDto.getPictureUrl());
        postEntity.setTime(postDto.getTime());
        postEntity.setEventTime(postDto.getEventTime());

        return PostConverter.convertPostEntityToDto(postEntity);
    }

    @Override
    public PostDto updateEvent(Integer id, PostDto postDto) {
        PostEntity postEntity = postRepository.findById(id).get();
        UserEntity user = userRepository.findById(postDto.getUser()).get();
        postEntity.setId(postDto.getId());
        postEntity.setUser(user);
        postEntity.setContent(postDto.getContent());
        postEntity.setPictureUrl(postDto.getPictureUrl());
        postEntity.setTime(postDto.getTime());
        postEntity.setEventTime(postDto.getEventTime());

        return PostConverter.convertPostEntityToDto(postEntity);
    }

    @Override
    public void delete(Integer id) {
        if (postRepository.findById(id).isPresent()){
            postRepository.deleteById(id);
        }

    }
}
