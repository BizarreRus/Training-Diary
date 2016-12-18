package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupDao {
    List getAll();

    void saveOrUpdate(MuscleGroup muscleGroup);

    MuscleGroup getByName(String name);

    MuscleGroup get(int id);

    void delete(MuscleGroup muscleGroup);

    void update(MuscleGroup muscleGroup);
}
