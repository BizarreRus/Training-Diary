package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupDao {
    List getAll();

    void save(MuscleGroup muscleGroup);

    MuscleGroup get(int id);

    void delete(int id);

    void delete(MuscleGroup muscleGroup);
}
