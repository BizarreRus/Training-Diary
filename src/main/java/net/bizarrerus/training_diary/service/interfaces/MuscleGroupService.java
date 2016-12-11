package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupService {

    List getAll();

    void saveOrUpdate(MuscleGroup muscleGroup);

    MuscleGroup getByName(String name);

    MuscleGroup get(int id);

    void delete(MuscleGroup muscleGroup);

    List getGroupNames();

    void delete(int id);

    void update(MuscleGroup muscleGroup);
}
