package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> index();
    User show(Long id);
    void update(User updateUser);
    void deleteUser(Long id);
}
