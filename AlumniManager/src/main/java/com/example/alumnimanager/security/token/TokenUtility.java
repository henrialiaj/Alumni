package com.example.alumnimanager.security.token;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
public class TokenUtility {

    private TokenUtility(){
        super();
    }

    public static TokenDetails getDetails(){
        return (TokenDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    public static String getUserNameFromToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
}
