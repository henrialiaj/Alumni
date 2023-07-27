package com.example.alumnimanager.comment.service.services;

import com.example.alumnimanager.comment.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);

    List<CommentDto> commentsPost(Integer postId);

    void delete(Integer id);
}
