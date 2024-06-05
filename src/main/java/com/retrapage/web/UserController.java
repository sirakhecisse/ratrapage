package com.retrapage.web;

import com.retrapage.dto.UserDTO;
import com.retrapage.entity.User;
import com.retrapage.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Query("users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Query("userById(id: Long!)")
    public UserDTO getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    @MutationMapping("createUser(user: UserInput!)")
    public UserDTO createUser(@Argument User userInput) {
        UserDTO userDTO = new UserDTO(userInput.getName(), userInput.getEmail());
        return userService.createUser(userDTO);
    }

    @MutationMapping("updateUser(id: Long!, user: UserInput!)")
    public UserDTO updateUser(@Argument Long id, @Argument User userInput) {
        UserDTO userDTO = new UserDTO(id, userInput.getName(), userInput.getEmail());
        userService.updateUser(id, userDTO);
        return userService.getUserById(id);
    }

    @MutationMapping("deleteUser(id: Long!)")
    public void deleteUser(@Argument Long id) {
        userService.deleteUser(id);
    }
}

