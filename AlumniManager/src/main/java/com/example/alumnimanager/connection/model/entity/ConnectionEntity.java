package com.example.alumnimanager.connection.model.entity;

import com.example.alumnimanager.connection.model.enums.ConnectionEnums;
import com.example.alumnimanager.user.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "connection")
public class ConnectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer connectionId;

    @Enumerated(EnumType.STRING)
    private ConnectionEnums connection;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "reciver_id")
    private UserEntity reciver;


}
