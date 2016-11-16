package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupDao {
    List getAll();

    void saveOrUpdate(MuscleGroup muscleGroup);

    MuscleGroup getByName(String name);

    MuscleGroup get(int id);

    void delete(MuscleGroup muscleGroup);
}
