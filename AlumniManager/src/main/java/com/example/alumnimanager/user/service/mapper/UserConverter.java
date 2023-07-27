package com.example.alumnimanager.user.service.mapper;

import com.example.alumnimanager.user.model.dto.UserDTO;
import com.example.alumnimanager.user.model.entity.UserEntity;

public class UserConverter {

    public static UserDTO convertUserToDto(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();

        userDTO.setUser_id((userEntity.getUser_id()));
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setRole(userEntity.getRole());
        userDTO.setPassword(userEntity.getPassword());

        return userDTO;
    }

    public static UserEntity convertDtoToUser(UserDTO user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUser_id(user.getUser_id());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(user.getRole());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }
}
