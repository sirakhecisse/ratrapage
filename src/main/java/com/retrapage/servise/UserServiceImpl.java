package com.retrapage.servise;

import com.retrapage.dto.UserDTO;
import com.retrapage.entity.User;
import com.retrapage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser);
    }
    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        userRepository.findById(id)
                .ifPresent(user -> {
                    user.setName(userDTO.getName());
                    user.setEmail(userDTO.getEmail());

                    userRepository.save(user);
                });
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

}

