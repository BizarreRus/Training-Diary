package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.TrainingDao;
import net.bizarrerus.training_diary.model.Training;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TrainingDaoImpl extends BaseDaoImpl implements TrainingDao {
    @Override
    @Transactional
    public Training get(int id) {
        return getSession().get(Training.class, id);
    }

    @Override
    @Transactional
    public void save(Training training) {
        getSession().saveOrUpdate(training);
    }

    @Override
    @Transactional
    public void delete(int id) {
        getSession().delete(get(id));
    }

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM Training").list();
    }
}
