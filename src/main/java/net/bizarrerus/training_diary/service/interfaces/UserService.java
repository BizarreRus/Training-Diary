package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.User;

public interface UserService {
    User get(int id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
