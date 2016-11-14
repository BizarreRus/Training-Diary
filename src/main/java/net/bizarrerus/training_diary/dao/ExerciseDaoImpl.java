package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ExerciseDaoImpl implements ExerciseDao{

    public ExerciseDaoImpl() {
    }

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Exercise> exercisesByGroupId(int group_id) {
        Query query = getSession().createQuery("FROM Exercise E WHERE E.group_id  =:id");
        query.setParameter("id", group_id);
        return query.list();
    }
}
