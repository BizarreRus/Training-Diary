package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.User;

public interface UserDao {

    User get(int id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
