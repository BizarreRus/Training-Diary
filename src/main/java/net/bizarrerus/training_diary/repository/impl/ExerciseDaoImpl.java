package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.ExerciseDao;
import net.bizarrerus.training_diary.model.Exercise;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExerciseDaoImpl extends BaseDaoImpl implements ExerciseDao {

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM Exercise").list();
    }

    @Override
    @Transactional
    public void delete(Exercise exercise) {
        getSession().delete(exercise);
    }

    @Override
    @Transactional
    public void delete(int id) {
        getSession().delete(get(id));
    }

    @Override
    @Transactional
    public Exercise get(int id) {
        return getSession().load(Exercise.class, id);
    }

    @Override
    @Transactional
    public void save(Exercise exercise) {
        getSession().saveOrUpdate(exercise);
    }
}
