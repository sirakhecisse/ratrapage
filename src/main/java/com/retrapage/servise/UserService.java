package com.retrapage.servise;

import com.retrapage.dto.UserDTO;
import com.retrapage.entity.User;
import com.retrapage.exception.UserNotFoundException;
import com.retrapage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface UserService {

    public List<UserDTO> getAllUsers();


    public UserDTO createUser(UserDTO userDTO);

    public void updateUser(Long id, UserDTO userDTO);

    public void deleteUser(Long id);

    UserDTO getUserById(Long id);
}

