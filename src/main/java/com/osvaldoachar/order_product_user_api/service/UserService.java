package com.osvaldoachar.order_product_user_api.service;

import com.osvaldoachar.order_product_user_api.dto.UserDto;
import com.osvaldoachar.order_product_user_api.entity.User;
import com.osvaldoachar.order_product_user_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getUserId(), user.getName(), user.getEmail()))
                .toList();
    }

    public UserDto findUserById(UUID userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
        return new UserDto(user.getUserId(), user.getName(), user.getEmail());
    }

    public UserDto createUser(UserDto userDto){
        var user = new User();

        user.setName(userDto.name());
        user.setEmail(userDto.email());

        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getUserId(), savedUser.getName(), savedUser.getEmail());
    }

    public UserDto updateUser(UUID userId, UserDto userDto){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setName(userDto.name());
        user.setEmail(userDto.email());

        User updatedUser = userRepository.save(user);

        return new UserDto(updatedUser.getUserId(), updatedUser.getName(), updatedUser.getEmail());
    }

    public void deleteUser(UUID userId){
        if (!userRepository.existsById(userId)){
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(userId);
    }
}
