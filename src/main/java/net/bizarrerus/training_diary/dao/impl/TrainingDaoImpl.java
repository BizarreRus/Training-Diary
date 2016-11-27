package net.bizarrerus.training_diary.dao.impl;

import net.bizarrerus.training_diary.dao.interfaces.TrainingDao;
import net.bizarrerus.training_diary.model.Training;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TrainingDaoImpl extends BaseDaoImpl implements TrainingDao {
    @Override
    @Transactional
    public Training get(int id) {
        return (Training) getSession().get(Training.class, id);
    }

    @Override
    @Transactional
    public void save(Training training) {
        getSession().save(training);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Training training) {
        getSession().saveOrUpdate(training);
    }

    @Override
    @Transactional
    public void update(Training training) {
        getSession().update(training);
    }

    @Override
    @Transactional
    public void delete(Training training) {
        getSession().delete(training);
    }

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM Training").list();
    }
}
