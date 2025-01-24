package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User findUser(int id);
}
