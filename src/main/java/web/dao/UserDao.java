package web.dao;

import web.models.User;

import javax.persistence.Query;
import java.util.List;


public interface UserDao {
    List<User> listUser();
    public void deleteUser(Long id);
    public void addUser(User user);

}
