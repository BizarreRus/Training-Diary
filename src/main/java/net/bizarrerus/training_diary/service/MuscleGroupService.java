package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;

import java.util.List;

public interface MuscleGroupService {

    List getAll();

    void saveOrUpdate(MuscleGroup muscleGroup);

    MuscleGroup getByName(String name);

    MuscleGroup get(int id);

    void delete(MuscleGroup muscleGroup);

    void updateGroup(Exercise exercise, String groupName);

    List getGroupNames();

    void deleteGroup(MuscleGroup muscleGroup);
}
