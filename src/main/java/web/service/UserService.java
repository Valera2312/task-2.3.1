package web.service;


import web.models.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void deleteUser(Long id);
    void addUser(User user);
}
