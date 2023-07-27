package com.example.alumnimanager.posts.controller;

import com.example.alumnimanager.posts.model.dto.PostDto;
import com.example.alumnimanager.posts.service.services.PostService;
import com.example.alumnimanager.user.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("{id}")
    public PostDto getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }

    @GetMapping("user/{id}")
    public List<PostDto> getPostsByUser(@PathVariable @RequestBody Integer id){
        return postService.findPostsByUser(id);
    }

    @PostMapping("newPost")
    public PostDto createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @PostMapping("newEvent")
    public PostDto createEvent(@RequestBody PostDto postDto){
        return postService.createEvent(postDto);
    }

    @GetMapping("AllEvents")
    public List<PostDto> AllEvents(){
        return postService.AllEvents();
    }

    @PutMapping("updatePost/{id}")
    public PostDto updatePost(@PathVariable @RequestBody Integer id, @RequestBody PostDto postDto){
        return postService.updatePost(id, postDto);
    }
    @PutMapping("updateEvent/{id}")
    public PostDto updateEvent(@PathVariable @RequestBody Integer id, @RequestBody PostDto postDto){
        return postService.updateEvent(id, postDto);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable @RequestBody Integer id){
        postService.delete(id);
    }
}
