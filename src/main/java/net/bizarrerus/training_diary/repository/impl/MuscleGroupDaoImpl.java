package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.MuscleGroupDao;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MuscleGroupDaoImpl extends BaseDaoImpl implements MuscleGroupDao {
    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM MuscleGroup").list();
    }

    @Override
    @Transactional
    public void save(MuscleGroup muscleGroup) {
        getSession().saveOrUpdate(muscleGroup);
    }

    @Override
    @Transactional
    public MuscleGroup get(int id) {
        return getSession().load(MuscleGroup.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        getSession().delete(get(id));
    }

    @Override
    @Transactional
    public void delete(MuscleGroup muscleGroup) {
        getSession().delete(muscleGroup);
    }
}
