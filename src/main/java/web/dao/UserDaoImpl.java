package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = findUser(id);
        entityManager.remove(user);
        entityManager.flush();
        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
    }
}
