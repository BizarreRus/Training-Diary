package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.MuscleGroup;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MuscleGroupDaoImpl extends BaseDaoImpl implements MuscleGroupDao {

    public MuscleGroupDaoImpl() {
    }

    @Override
    @Transactional
    public List getMuscleGroupList() {
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

    @Override
    @Transactional
    public List getGroupNames() {
        List<String> names = new ArrayList<>();
        List<MuscleGroup> tmp = getMuscleGroupList();
        for (MuscleGroup muscleGroup : tmp) {
            names.add(muscleGroup.getGroup_name());
        }
        return names;
    }

    @Override
    public MuscleGroup get(int id) {
        return (MuscleGroup) getSession().load(MuscleGroup.class, new Integer(id));
    }
}
