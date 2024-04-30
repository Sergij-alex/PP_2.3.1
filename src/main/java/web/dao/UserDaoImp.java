package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Override
    public void update(User updateUser) {
        entityManager.merge(updateUser);
//        User userToBeUpdated = show(id);
//        userToBeUpdated.setFirstName(updateUser.getFirstName());
//        userToBeUpdated.setLastName(updateUser.getLastName());
//        userToBeUpdated.setEmail(updateUser.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(show(id));
    }

}
