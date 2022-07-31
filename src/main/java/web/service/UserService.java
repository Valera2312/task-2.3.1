package web.service;


import web.models.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void deleteUser(Long id);
    void addUser(User user);
    void addUser(String name,String lastName, int age);
    void editUser(String name,String lastName, int age, Long id);
    public User findById(Long id);
}
