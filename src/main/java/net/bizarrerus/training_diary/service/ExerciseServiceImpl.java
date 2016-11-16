package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.dao.ExerciseDao;
import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
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
        exerciseDao.delete(id);
    }
}
