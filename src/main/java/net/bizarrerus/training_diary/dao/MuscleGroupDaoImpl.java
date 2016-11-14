package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.MuscleGroup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MuscleGroupDaoImpl implements MuscleGroupDao {

    public MuscleGroupDaoImpl() {
    }

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<MuscleGroup> getMuscleGroupList() {
        return getSession().createQuery("from MuscleGroup").list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(MuscleGroup muscleGroup) {
        getSession().saveOrUpdate(muscleGroup);
    }

    @Override
    @Transactional
    public MuscleGroup getByName(String name) {
        Query query = getSession().createQuery("FROM MuscleGroup MG WHERE MG.group_name =:name");
        query.setParameter("name", name);
        MuscleGroup muscleGroup = (MuscleGroup) query.list().get(0);

        return muscleGroup;
    }

    @Override
    @Transactional
    public void deleteByName(MuscleGroup muscleGroup) {
        getSession().delete(muscleGroup);
    }
}
