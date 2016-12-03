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
    public void save(Complex complex) {
        complexDao.save(complex);
    }

    @Override
    public List getAll() {
        return complexDao.getAll();
    }

    @Override
    public void delete(int id) {
        complexDao.delete(id);
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
