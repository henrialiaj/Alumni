package com.example.alumnimanager.posts.model.entity;
import com.example.alumnimanager.posts.model.enums.PostType;
import com.example.alumnimanager.user.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String content;

    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    private PostType type;

    private LocalDateTime time;

    private LocalDateTime eventTime;


}
