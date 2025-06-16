package com.vehicle.user_service.service;

import com.vehicle.user_service.entity.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
