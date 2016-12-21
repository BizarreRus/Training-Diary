package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.repository.interfaces.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MuscleGroupServiceImpl implements MuscleGroupService {
    @Autowired
    private MuscleGroupDao muscleGroupDao;

    @Override
    @Transactional
    public List getAll() {
        return muscleGroupDao.getAll();
    }

    @Override
    @Transactional
    public void save(MuscleGroup muscleGroup) {
        muscleGroupDao.save(muscleGroup);
    }

    @Override
    @Transactional
    public MuscleGroup get(int id) {
        return muscleGroupDao.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        MuscleGroup muscleGroup = get(id);
        MuscleGroup defaultGroup = get(1);
        Set<Exercise> exercises = muscleGroup.getExerciseSet();
        for (Exercise exercise : exercises) {
            exercise.setMuscleGroup(defaultGroup);
        }
        defaultGroup.getExerciseSet().addAll(exercises);
        save(defaultGroup);
        muscleGroup.getExerciseSet().clear();
        muscleGroupDao.delete(muscleGroup);
    }

//    @Override
//    @Transactional
//    public void delete(MuscleGroup muscleGroup) {
//        MuscleGroup defaultGroup = get(1);
//        Set<Exercise> exercises = muscleGroup.getExerciseSet();
//        for (Exercise exercise : exercises) {
//            exercise.setMuscleGroup(defaultGroup);
//        }
//        defaultGroup.getExerciseSet().addAll(exercises);
//        save(defaultGroup);
//        muscleGroup.getExerciseSet().clear();
//        muscleGroupDao.delete(muscleGroup.getId());
//    }

    @Override
    public void update(MuscleGroup muscleGroup) {
        MuscleGroup oldGroup = muscleGroupDao.get(muscleGroup.getId());
        Set<Exercise> exercises = new HashSet<>(oldGroup.getExerciseSet());
        for (Exercise exercise : exercises) {
            exercise.setMuscleGroup(muscleGroup);
        }
        muscleGroupDao.save(muscleGroup);
    }
}