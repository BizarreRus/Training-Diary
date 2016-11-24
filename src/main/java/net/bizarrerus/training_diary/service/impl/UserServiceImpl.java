package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.UserDao;
import net.bizarrerus.training_diary.model.User;
import net.bizarrerus.training_diary.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
