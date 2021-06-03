package xyz.ignatev.deletantrest.service;

import xyz.ignatev.deletantrest.entity.User;

public interface UserService {
    User getUserByEmail(String email);

    boolean addUser(User user);

    boolean activateUser(String code);
}
