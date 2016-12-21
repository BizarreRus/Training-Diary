package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.UserDao;
import net.bizarrerus.training_diary.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    @Transactional
    public User get(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        getSession().delete(user);
    }

    @Override
    public List getAll() {
        return getSession().createQuery("FROM User").list();
    }
}
