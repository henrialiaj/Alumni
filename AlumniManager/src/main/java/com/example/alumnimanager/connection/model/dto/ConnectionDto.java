package com.example.alumnimanager.connection.model.dto;

import com.example.alumnimanager.connection.model.enums.ConnectionEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDto {
    private Integer connectionId;
    private ConnectionEnums connection;
    private Integer sender;
    private Integer reciver;
}
