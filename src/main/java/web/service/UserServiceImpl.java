package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    {
        User user = new User();
        user.setUsername("admin");
        user.setAge(5);
        user.setEmail("admin@gmail.com");
        User user1 = new User();
        user1.setUsername("admin2");
        user1.setAge(5);
        user1.setEmail("admin2@gmail.com");
        userDao.createUser(user);
        userDao.createUser(user1);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }
}