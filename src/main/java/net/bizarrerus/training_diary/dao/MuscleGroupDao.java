package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupDao {
    List getMuscleGroupList();

    void saveOrUpdate(MuscleGroup muscleGroup);

    MuscleGroup getByName(String name);

    void deleteByName(MuscleGroup muscleGroup);

    List getGroupNames();

    MuscleGroup get(int id);
}
