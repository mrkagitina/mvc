package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User findUser(int id);
}
