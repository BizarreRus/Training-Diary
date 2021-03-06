package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.ActivityDao;
import net.bizarrerus.training_diary.model.Activity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ActivityDaoImpl extends BaseDaoImpl implements ActivityDao{
    @Override
    @Transactional
    public void delete(Activity activity) {
        getSession().delete(activity);
    }

    @Override
    @Transactional
    public Activity get(int id) {
        return getSession().load(Activity.class, id);
    }

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM Activity").list();
    }

    @Override
    @Transactional
    public void save(Activity activity) {
        getSession().saveOrUpdate(activity);
    }
}
