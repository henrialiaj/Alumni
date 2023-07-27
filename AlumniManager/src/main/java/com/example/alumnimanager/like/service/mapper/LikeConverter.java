package com.example.alumnimanager.like.service.mapper;

import com.example.alumnimanager.like.model.dto.LikeDto;
import com.example.alumnimanager.like.model.entity.LikeEntity;

public class LikeConverter {

    public static LikeDto converLikeEntityToDto(LikeEntity likeEntity){
        LikeDto likeDto = new LikeDto();
        likeDto.setLikeId(likeEntity.getLikeId());
        likeDto.setUser(likeEntity.getUser().getUser_id());
        likeDto.setPost(likeEntity.getPost().getId());

        return likeDto;
    }
}
