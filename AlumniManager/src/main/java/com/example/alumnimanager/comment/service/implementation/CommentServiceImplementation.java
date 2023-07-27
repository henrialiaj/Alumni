package com.example.alumnimanager.comment.service.implementation;

import com.example.alumnimanager.comment.model.dto.CommentDto;
import com.example.alumnimanager.comment.model.entity.CommentEntity;
import com.example.alumnimanager.comment.repository.CommentRepository;
import com.example.alumnimanager.comment.service.mapper.CommentConverter;
import com.example.alumnimanager.comment.service.services.CommentService;
import com.example.alumnimanager.posts.repository.PostRepository;
import com.example.alumnimanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        CommentEntity comment = new CommentEntity();
        var user = userRepository.findById(commentDto.getUser()).get();
        var post = postRepository.findById(commentDto.getPost()).get();
        comment.setCommentId(commentDto.getCommentId());
        comment.setCommentContent(commentDto.getCommentContent());
        comment.setUser(user);
        comment.setPost(post);

        commentRepository.save(comment);

        return CommentConverter.convertCommentEntityToDto(comment);
    }

    @Override
    public List<CommentDto> commentsPost(Integer postId) {
        return commentRepository.findAll()
                .stream()
                .filter(comment -> comment.getPost().getId().equals(postId)
                && comment.getPost().getUser().getUser_id().equals(postId))
                .map(CommentConverter::convertCommentEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (commentRepository.findById(id).isPresent()){
            commentRepository.deleteById(id);
        }

    }
}
