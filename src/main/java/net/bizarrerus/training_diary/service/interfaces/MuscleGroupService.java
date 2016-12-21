package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupService {
    List getAll();

    void save(MuscleGroup muscleGroup);

    MuscleGroup get(int id);

//    void delete(MuscleGroup muscleGroup);

    void delete(int id);

    void update(MuscleGroup muscleGroup);
}
