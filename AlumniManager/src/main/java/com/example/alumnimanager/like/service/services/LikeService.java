package com.example.alumnimanager.like.service.services;

import com.example.alumnimanager.like.model.dto.LikeDto;

import java.util.List;

public interface LikeService {

    LikeDto addLike(LikeDto likeDto);

    void delete(Integer id);

    Long postLikes(Integer id);
}
