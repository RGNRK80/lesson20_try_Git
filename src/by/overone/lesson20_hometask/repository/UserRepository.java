package by.overone.lesson20_hometask.repository;

import by.overone.lesson20_hometask.entity.User;

public interface UserRepository {

    User[] getAllUsers();

    User getUserById(long id);

    User[] getUserByFullName(String fullName);

    User removeUserById(long id);

    User addUser(User user);

}