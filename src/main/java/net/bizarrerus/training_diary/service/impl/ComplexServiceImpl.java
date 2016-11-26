package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.ComplexDao;
import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ComplexServiceImpl implements ComplexService {
    @Autowired
    ComplexDao complexDao;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    MuscleGroupService muscleGroupService;

    @Override
    @Transactional
    public void save(Complex complex, List<Integer> exercisesID) {
        complex.setExercises(new HashSet<>());
        Exercise exercise;
        for (Integer id : exercisesID) {
            exercise = exerciseService.get(id);
            exercise.getComplexes().add(complex);
            complex.getExercises().add(exercise);
            muscleGroupService.saveOrUpdate(exercise.getMuscleGroup());
        }
    }

    @Override
    @Transactional
    public List getAll() {
        return complexDao.getAll();
    }

    @Override
    @Transactional
    public void delete(int id) {
        complexDao.delete(id);
    }

    @Override
    @Transactional
    public void deleteExercise(Exercise exercise){
        for (Complex complex : exercise.getComplexes()) {
            complex.getExercises().remove(exercise);
            if (complex.getExercises().isEmpty()){
                delete(complex.getId());
            }
        }
        for (Activity activity : exercise.getActivities()) {
            activity.setExercise(exercise);
        }

        exercise.getActivities().clear();
        exercise.getComplexes().clear();

        exerciseService.delete(exercise);
    }

    @Override
    public Complex get(int id) {
        return complexDao.get(id);
    }

    @Override
    public void update(Complex complex) {
        Complex oldComplex = complexDao.get(complex.getId());
        complex.setExercises(oldComplex.getExercises());
        complexDao.update(complex);
    }
}
