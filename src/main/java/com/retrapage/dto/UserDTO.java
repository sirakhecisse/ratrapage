package com.retrapage.dto;

import com.retrapage.entity.User;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public UserDTO(String name, String email) {
    }

    public UserDTO(Long id, String name, String email) {
    }
}

