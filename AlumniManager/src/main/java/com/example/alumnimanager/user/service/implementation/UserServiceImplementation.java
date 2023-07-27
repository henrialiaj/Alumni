package com.example.alumnimanager.user.service.implementation;

import com.example.alumnimanager.user.model.dto.UserDTO;
import com.example.alumnimanager.user.model.entity.UserEntity;
import com.example.alumnimanager.user.model.enums.Role;
import com.example.alumnimanager.user.repository.UserRepository;
import com.example.alumnimanager.user.service.mapper.UserConverter;
import com.example.alumnimanager.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUser(Integer id) {
        if (userRepository.findById(id).isPresent()
                && userRepository.findById(id).get().getValidity().equals(Boolean.TRUE)){
            return UserConverter.convertUserToDto(userRepository.findById(id).get());
        }
        return new UserDTO();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_id(userDTO.getUser_id());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(Role.USER);
        userEntity.setValidity(Boolean.TRUE);

        userRepository.save(userEntity);

        return UserConverter.convertUserToDto(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .filter(userEntity -> userEntity.getValidity().equals(Boolean.TRUE)
                        && userEntity.getRole().equals(Role.USER))
                .map(UserConverter::convertUserToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        return userRepository.findAll()
                .stream()
                .filter(userEntity -> userEntity.getValidity().equals(Boolean.TRUE)
                        && userEntity.getRole().equals(Role.ADMIN))
                .map(UserConverter::convertUserToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setUser_id(userDTO.getUser_id());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(userDTO.getRole());

        return UserConverter.convertUserToDto(userEntity);
    }

    @Override
    public void delete(Integer id) {
        if (userRepository.findById(id).isPresent()
                && userRepository.findById(id).get().getValidity().equals(Boolean.TRUE)){
            UserEntity userToDelete = userRepository.findById(id).get();
            userToDelete.setValidity(Boolean.FALSE);
            userRepository.save(userToDelete);
        }

    }


}
