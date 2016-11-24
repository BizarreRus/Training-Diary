package net.bizarrerus.training_diary.dao.impl;

import net.bizarrerus.training_diary.dao.interfaces.UserDao;
import net.bizarrerus.training_diary.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    @Transactional
    public User get(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        getSession().update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        getSession().delete(user);
    }
}
