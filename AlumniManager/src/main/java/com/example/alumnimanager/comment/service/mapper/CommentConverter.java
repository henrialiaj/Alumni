package com.example.alumnimanager.comment.service.mapper;

import com.example.alumnimanager.comment.model.dto.CommentDto;
import com.example.alumnimanager.comment.model.entity.CommentEntity;

public class CommentConverter {

    public static CommentDto convertCommentEntityToDto(CommentEntity comment){
        var comentDto = new CommentDto();

        comentDto.setCommentId(comment.getCommentId());
        comentDto.setCommentContent(comment.getCommentContent());
        comentDto.setUser(comment.getUser().getUser_id());
        comentDto.setPost(comment.getPost().getId());

        return comentDto;
    }
}
