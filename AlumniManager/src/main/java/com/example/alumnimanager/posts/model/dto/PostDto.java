package com.example.alumnimanager.posts.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Integer id;
    private Integer user;
    private String content;
    private String pictureUrl;
    private LocalDateTime time;
    private LocalDateTime eventTime;
}
