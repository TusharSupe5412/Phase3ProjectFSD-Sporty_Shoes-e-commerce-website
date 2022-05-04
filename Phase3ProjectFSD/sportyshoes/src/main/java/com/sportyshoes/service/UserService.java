package com.sportyshoes.service;

import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.entities.Product;
import com.sportyshoes.entities.User;

import java.util.List;

public interface UserService {

    public User registerUser(UserRequestDTO userRequestDTO);

    public List<User> getUser();

    public User getUserById(int userId);

    public User updateProduct(User user);

    public User removeUserById(int id);
}
