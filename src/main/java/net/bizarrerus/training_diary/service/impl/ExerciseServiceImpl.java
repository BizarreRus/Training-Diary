package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.repository.interfaces.ExerciseDao;
import net.bizarrerus.training_diary.model.*;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Autowired
    private MuscleGroupService muscleGroupService;
    @Autowired
    private ComplexService complexService;
    @Autowired
    private TrainingService trainingService;

    @Override
    public List getAll() {
        return exerciseDao.getAll();
    }

    @Override
    public Exercise get(int id) {
        return exerciseDao.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Exercise exercise = get(id);
        for (Complex complex : exercise.getComplexes()) {
            complex.getExercises().remove(exercise);
            if (complex.getExercises().isEmpty()) {
                complexService.delete(complex.getId());
            }
        }
        for (Training training : exercise.getTrainings()) {
            training.getExercises().remove(exercise);
            if (training.getExercises().isEmpty()) {
                trainingService.delete(training.getId());
            }
        }
        exercise.getTrainings().clear();
        exercise.getActivities().clear();
        exercise.getComplexes().clear();

        exerciseDao.delete(exercise);
    }

    @Override
    public void save(Exercise exercise) {
        exerciseDao.save(exercise);
    }

    @Override
    public void save(Exercise exercise, int muscleGroupId) {
        MuscleGroup muscleGroup = muscleGroupService.get(muscleGroupId);
        exercise.setMuscleGroup(muscleGroup);
        muscleGroup.getExerciseSet().removeIf(exer -> exer.getId() == exercise.getId());
        muscleGroup.getExerciseSet().add(exercise);
        muscleGroupService.save(muscleGroup);
    }

    @Override
    public void update(Exercise exercise) {
        save(exercise);
    }
}

