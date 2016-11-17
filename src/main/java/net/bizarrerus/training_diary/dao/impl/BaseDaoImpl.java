package net.bizarrerus.training_diary.dao.impl;

import net.bizarrerus.training_diary.dao.interfaces.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
