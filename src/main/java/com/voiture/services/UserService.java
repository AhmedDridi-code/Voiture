package com.voiture.services;

import com.voiture.entities.*;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
