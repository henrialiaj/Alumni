package com.example.alumnimanager.connection.service.services;

import com.example.alumnimanager.connection.model.dto.ConnectionDto;
import com.example.alumnimanager.expections.UserNotFound;

import java.util.List;

public interface ConnectionService {

    void cancelRequest(Integer id);

    ConnectionDto sendRequest(Integer senderId, Integer reciverId) throws UserNotFound;

    List<ConnectionDto> allRequests(Integer id);

    void acceptRequest(Integer connectionId);

    void rejectRequest(Integer connectionId);

}
