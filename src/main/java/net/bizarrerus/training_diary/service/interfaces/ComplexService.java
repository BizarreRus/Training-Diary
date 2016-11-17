package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.model.Exercise;

import java.util.List;

public interface ComplexService {
    void save(Complex complex, List<Integer> exercisesID);

    List getAll();

    void delete(int id);

    public void deleteExercise(Exercise exercise);
}
