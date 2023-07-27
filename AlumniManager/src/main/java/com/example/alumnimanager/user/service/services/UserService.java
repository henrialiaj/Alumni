package com.example.alumnimanager.user.service.services;

import com.example.alumnimanager.user.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(Integer id);

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    List<UserDTO> getAllAdmins();

    UserDTO updateUser(Integer id, UserDTO userDTO);

    void delete(Integer id);
}
