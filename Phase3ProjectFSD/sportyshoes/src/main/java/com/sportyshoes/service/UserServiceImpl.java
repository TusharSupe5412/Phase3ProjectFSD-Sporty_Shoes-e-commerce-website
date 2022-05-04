package com.sportyshoes.service;

import com.sportyshoes.dto.ProductRequestDTO;
import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.entities.Product;
import com.sportyshoes.entities.User;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(UserRequestDTO userRequestDTO) {
        return userRepository.save(DtoToEntityMapper(userRequestDTO));
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateProduct(User user) {
        return userRepository.save(user);
    }

    @Override
    public User removeUserById(int id) {
        User u = userRepository.findById(id).get();
        userRepository.delete(u);
        return u;
    }


    public User DtoToEntityMapper(UserRequestDTO userRequestDTO){
        return User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .build();
    }
}
