package net.bizarrerus.training_diary.dao.impl;

import net.bizarrerus.training_diary.dao.interfaces.MuscleGroupDao;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MuscleGroupDaoImpl extends BaseDaoImpl implements MuscleGroupDao {

    public MuscleGroupDaoImpl() {
    }

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM MuscleGroup").list();
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
        List queryList = query.list();
        if (!queryList.isEmpty()){
            return (MuscleGroup) queryList.get(0);
        }
        return new MuscleGroup();
    }

    @Override
    @Transactional
    public MuscleGroup get(int id) {
        return (MuscleGroup) getSession().load(MuscleGroup.class, id);
    }

    @Override
    @Transactional
    public void delete(MuscleGroup muscleGroup) {
        getSession().delete(muscleGroup);
    }

    @Override
    @Transactional
    public void update(MuscleGroup muscleGroup) {
        getSession().update(muscleGroup);
    }
}
