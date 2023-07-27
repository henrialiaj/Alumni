package com.example.alumnimanager.connection.service.mapper;

import com.example.alumnimanager.connection.model.dto.ConnectionDto;
import com.example.alumnimanager.connection.model.entity.ConnectionEntity;

public class ConnectionConverter {

    public static ConnectionDto convertConnectionEntityToDto(ConnectionEntity connectionEntity){
        var connection = new ConnectionDto();

        connection.setConnectionId(connectionEntity.getConnectionId());
        connection.setSender(connectionEntity.getSender().getUser_id());
        connection.setReciver(connectionEntity.getReciver().getUser_id());

        return connection;
    }
}
