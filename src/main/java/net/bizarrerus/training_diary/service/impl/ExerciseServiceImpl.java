package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.ExerciseDao;
import net.bizarrerus.training_diary.dao.interfaces.MuscleGroupDao;
import net.bizarrerus.training_diary.model.*;
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
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    ExerciseDao exerciseDao;
    @Autowired
    MuscleGroupService muscleGroupService;
    @Autowired
    ComplexService complexService;

    @Override
    @Transactional
    public List exercisesByGroupId(int group_id) {
        return exerciseDao.exercisesByGroupId(group_id);
    }

    @Override
    @Transactional
    public List getAll() {
        return exerciseDao.getAll();
    }

    @Override
    @Transactional
    public Exercise get(int id) {
        return exerciseDao.get(id);
    }

    @Override
    @Transactional
    public void delete(Exercise exercise) {
        exerciseDao.delete(exercise);
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
        }
        exercise.getTrainings().clear();
        exercise.getActivities().clear();
        exercise.getComplexes().clear();

        delete(exercise);
    }

    @Override
    @Transactional
    public void save(Exercise exercise) {
        exerciseDao.save(exercise);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Exercise exercise, String groupName) {
        MuscleGroup muscleGroup = muscleGroupService.getByName(groupName);
        exercise.setMuscleGroup(muscleGroup);
        muscleGroup.getExerciseSet().add(exercise);
        muscleGroupService.saveOrUpdate(muscleGroup);
    }

    @Override
    public void update(Exercise exercise) {
        Exercise oldExercise = exerciseDao.get(exercise.getId());
        exercise.setMuscleGroup(oldExercise.getMuscleGroup());
        exercise.setComplexes(oldExercise.getComplexes());
        exerciseDao.update(exercise);
    }
}

