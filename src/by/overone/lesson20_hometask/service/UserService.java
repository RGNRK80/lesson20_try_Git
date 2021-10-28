package by.overone.lesson20_hometask.service;

import by.overone.lesson20_hometask.entity.User;

public interface UserService {

    User[] getAllUsers();

    User removeUserById(long id);
    User getUserById(long id);
    User[] getUserByFullName(String fullName);
    User addUser(User user);
}
