package com.example.alumnimanager.comment.controller;

import com.example.alumnimanager.comment.model.dto.CommentDto;
import com.example.alumnimanager.comment.service.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto commentDto){
        return commentService.createComment(commentDto);
    }

    @GetMapping("/{postId}")
    public List<CommentDto> commentsPost(@PathVariable Integer postId){
        return commentService.commentsPost(postId);
    }

    @DeleteMapping("{commentId}")
    void delete(@PathVariable Integer commentId){
        commentService.delete(commentId);
    }
}
