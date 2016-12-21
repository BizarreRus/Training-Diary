package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.Exercise;

import java.util.List;

public interface ExerciseDao {

    List getAll();

    void delete(int id);

    Exercise get(int id);

    void delete(Exercise exercise);

    void save(Exercise exercise);
}
