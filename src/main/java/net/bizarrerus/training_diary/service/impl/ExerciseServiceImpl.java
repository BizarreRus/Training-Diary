package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.ExerciseDao;
import net.bizarrerus.training_diary.dao.interfaces.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    ExerciseDao exerciseDao;
    @Autowired
    MuscleGroupDao muscleGroupDao;
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
        complexService.deleteExercise(get(id));
    }

    @Override
    @Transactional
    public void save(Exercise exercise) {
        exerciseDao.save(exercise);
    }
}

