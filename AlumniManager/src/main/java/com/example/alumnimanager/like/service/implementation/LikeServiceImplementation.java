package com.example.alumnimanager.like.service.implementation;

import com.example.alumnimanager.like.model.dto.LikeDto;
import com.example.alumnimanager.like.model.entity.LikeEntity;
import com.example.alumnimanager.like.repository.LikeRepository;
import com.example.alumnimanager.like.service.mapper.LikeConverter;
import com.example.alumnimanager.like.service.services.LikeService;
import com.example.alumnimanager.posts.repository.PostRepository;
import com.example.alumnimanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImplementation implements LikeService {

    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public LikeDto addLike(LikeDto likeDto) {
        LikeEntity like = new LikeEntity();
        var post = postRepository.findById(likeDto.getPost()).get();
        var user = userRepository.findById(likeDto.getUser()).get();
        like.setLikeId(likeDto.getLikeId());
        like.setUser(user);
        like.setPost(post);

        likeRepository.save(like);

        return LikeConverter.converLikeEntityToDto(like);
    }

    @Override
    public void delete(Integer id) {
        if (likeRepository.findById(id).isPresent()){
            likeRepository.deleteById(id);
        }

    }

    @Override
    public Long postLikes(Integer id) {
        return likeRepository.findAll()
                .stream()
                .filter(likeEntity -> likeEntity.getPost().getId().equals(id))
                .map(LikeConverter::converLikeEntityToDto)
                .count();
    }
}
