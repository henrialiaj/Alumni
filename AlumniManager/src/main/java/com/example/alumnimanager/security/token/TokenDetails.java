package com.example.alumnimanager.security.token;

import com.example.alumnimanager.user.model.enums.Role;
import lombok.Data;

@Data
public final class TokenDetails {

    private final String id;
    private final String email;
    private final Role role;
}
