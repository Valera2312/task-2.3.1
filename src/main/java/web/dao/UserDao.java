package web.dao;

import web.models.User;
import java.util.List;


public interface UserDao {
    List<User> listUser();
    void deleteUser(Long id);
    void addUser(User user);
    void editUser(User user);
    User findById(Long id);
}
