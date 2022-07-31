package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {

        return userDao.listUser();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addUser(String name, String lastName, int age) {
        userDao.addUser(name,lastName,age);
    }

    @Override
    public void editUser(String name, String lastName, int age, Long id) {
        userDao.editUser(name,lastName,age,id);
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }
}

