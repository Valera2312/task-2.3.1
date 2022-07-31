package web.dao;

import web.models.User;

import javax.persistence.Query;
import java.util.List;


public interface UserDao {
    List<User> listUser();
    public void deleteUser(Long id);
    public void addUser(User user);
    public void addUser(String name,String lastName, int age);
    public void editUser(String name,String lastName, int age,Long id);
    public User findById(Long id);
}
