
package com.example.alumnimanager.like.model.entity;


import com.example.alumnimanager.posts.model.entity.PostEntity;
import com.example.alumnimanager.user.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "likes")
public class LikeEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer likeId;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "user_id")
     private UserEntity user;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "id")
     private PostEntity post;


}
