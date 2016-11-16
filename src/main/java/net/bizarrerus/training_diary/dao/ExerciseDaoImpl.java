package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.Exercise;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExerciseDaoImpl extends BaseDaoImpl implements ExerciseDao{

    public ExerciseDaoImpl() {
    }

    @Override
    @Transactional
    public List<Exercise> exercisesByGroupId(int group_id) {
        Query query = getSession().createQuery("FROM Exercise E WHERE E.group_id  =:id");
        query.setParameter("id", group_id);
        return query.list();
    }

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
        return (Exercise) getSession().load(Exercise.class, id);
    }

}
