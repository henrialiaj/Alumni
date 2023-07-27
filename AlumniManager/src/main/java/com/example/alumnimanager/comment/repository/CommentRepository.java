package com.example.alumnimanager.comment.repository;

import com.example.alumnimanager.comment.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
