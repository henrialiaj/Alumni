package com.example.alumnimanager.like.controller;

import com.example.alumnimanager.like.model.dto.LikeDto;
import com.example.alumnimanager.like.service.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping
    public LikeDto addLike(@RequestBody LikeDto likeDto){
        return likeService.addLike(likeDto);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        likeService.delete(id);
    }

    @GetMapping("{id}")
    public Long postLikes(@PathVariable @RequestBody Integer id){
        return likeService.postLikes(id);
    }
}
