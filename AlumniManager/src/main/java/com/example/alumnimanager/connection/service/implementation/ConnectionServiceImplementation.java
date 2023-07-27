package com.example.alumnimanager.connection.service.implementation;

import com.example.alumnimanager.connection.model.dto.ConnectionDto;
import com.example.alumnimanager.connection.model.entity.ConnectionEntity;
import com.example.alumnimanager.connection.model.enums.ConnectionEnums;
import com.example.alumnimanager.connection.repository.ConnectionRepository;
import com.example.alumnimanager.connection.service.mapper.ConnectionConverter;
import com.example.alumnimanager.connection.service.services.ConnectionService;
import com.example.alumnimanager.expections.UserNotFound;
import com.example.alumnimanager.user.model.entity.UserEntity;
import com.example.alumnimanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConnectionServiceImplementation implements ConnectionService {

    @Autowired
    ConnectionRepository connectionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void cancelRequest(Integer id) {
        connectionRepository.deleteById(id);
    }

    @Override
    public ConnectionDto sendRequest(Integer senderId, Integer reciverId) throws UserNotFound {
        Optional<UserEntity> senderUser = userRepository.findById(senderId);
        Optional<UserEntity> reciverUser = userRepository.findById(reciverId);
        if (senderUser.isEmpty() || reciverUser.isEmpty()){
            throw new UserNotFound("User's not found");

        }

        else if (connectionRepository.findAll().stream()
                .anyMatch(connectionEntity -> connectionEntity.getSender().getUser_id().equals(senderId)
                && connectionEntity.getReciver().getUser_id().equals(reciverId)
                && (connectionEntity.getConnection().equals(ConnectionEnums.PENDING)
                        || connectionEntity.getConnection().equals(ConnectionEnums.ACCEPTED))
                )
        ){
            throw new  UserNotFound("Connection Request already exists and is PENDING!");
        }
        else {
            var newConnection = new ConnectionEntity();
            var sender = senderUser.get();
            var reciver = reciverUser.get();
            newConnection.setSender(sender);
            newConnection.setReciver(reciver);
            newConnection.setConnection(ConnectionEnums.PENDING);

            connectionRepository.save(newConnection);

            return ConnectionConverter.convertConnectionEntityToDto(newConnection);
        }

    }




    @Override
    public List<ConnectionDto> allRequests(Integer id) {
        return connectionRepository.findAll()
                .stream()
                .filter(connectionEntity -> connectionEntity.getConnection().equals(ConnectionEnums.PENDING)
                        && connectionEntity.getReciver().getUser_id().equals(id))
                .map(ConnectionConverter::convertConnectionEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void acceptRequest(Integer connectionId) {
        var connection = connectionRepository.findById(connectionId).get();
        connection.setConnection(ConnectionEnums.ACCEPTED);
        connectionRepository.save(connection);
    }

    @Override
    public void rejectRequest(Integer connectionId) {
        var connection = connectionRepository.findById(connectionId).get();
        connection.setConnection(ConnectionEnums.REJECTED);
        connectionRepository.save(connection);
    }
}
