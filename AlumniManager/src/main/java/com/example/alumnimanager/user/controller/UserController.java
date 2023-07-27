package com.example.alumnimanager.user.controller;

import com.example.alumnimanager.user.model.dto.UserDTO;
import com.example.alumnimanager.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("AllUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("AllAdmins")
    public List<UserDTO> getAllAdmins(){
        return userService.getAllAdmins();
    }

    @PutMapping("update/{id}")
    public UserDTO updateUser(@PathVariable @RequestBody Integer id, UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}
