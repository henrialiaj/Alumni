package com.example.alumnimanager.like.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private Integer likeId;
    private Integer user;
    private Integer post;
}
