package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.User;

import java.util.List;

public interface UserDao {

    User get(int id);

    void save(User user);

    void delete(User user);

    List getAll();
}
