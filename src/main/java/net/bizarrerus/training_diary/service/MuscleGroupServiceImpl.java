package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MuscleGroupServiceImpl implements MuscleGroupService{
    @Autowired
    private MuscleGroupDao muscleGroupDao;

    @Override
    @Transactional
    public void updateGroup(Exercise exercise, String groupName) {
        MuscleGroup muscleGroup = muscleGroupDao.getByName(groupName);
        exercise.setMuscleGroup(muscleGroup);
        muscleGroup.getExerciseSet().add(exercise);
        muscleGroupDao.saveOrUpdate(muscleGroup);
    }
}
