package com.example.alumnimanager.connection.controller;

import com.example.alumnimanager.connection.model.dto.ConnectionDto;
import com.example.alumnimanager.connection.service.services.ConnectionService;
import com.example.alumnimanager.expections.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/connections")
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @PostMapping("request/{senderId}/{reciverId}")
    public ConnectionDto sendRequest( @PathVariable Integer senderId, @PathVariable Integer reciverId) throws UserNotFound {
        return connectionService.sendRequest(senderId, reciverId);
    }

    @GetMapping("user/{id}")
    public List<ConnectionDto> allRequestes(@PathVariable Integer id){
        return connectionService.allRequests(id);
    }

    @PutMapping("accept/{connectionId}")
    void acceptRequest(@PathVariable Integer connectionId){
        connectionService.acceptRequest(connectionId);
    }

    @PutMapping("reject/{connectionId}")
    void rejectRequest(@PathVariable Integer connectionId){
        connectionService.rejectRequest(connectionId);
    }

    @DeleteMapping("delete/{id}")
    void cancelRequest(@PathVariable Integer id){
        connectionService.cancelRequest(id);
    }

}
