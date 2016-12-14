package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Exercise;

import java.util.List;

public interface ExerciseService {
    List exercisesByGroupId(int group_id);

    List getAll();

    Exercise get(int id);

    void delete(Exercise exercise);

    void delete(int id);

    void save(Exercise exercise);

    void saveOrUpdate(Exercise exercise, int muscleGroupId);

    void update(Exercise exercise);
}
