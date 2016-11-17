package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.Exercise;

import java.util.List;

public interface ExerciseDao {
    List exercisesByGroupId(int group_id);

    List getAll();

    void delete(Exercise exercise);

    void delete(int id);

    Exercise get(int id);

    void save(Exercise exercise);
}
