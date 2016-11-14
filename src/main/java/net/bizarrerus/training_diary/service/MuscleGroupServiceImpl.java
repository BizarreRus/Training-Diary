package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.dao.ExerciseDao;
import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.dao.MuscleGroupDaoImpl;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MuscleGroupServiceImpl implements MuscleGroupService{
    @Autowired
    private MuscleGroupDao muscleGroupDao;

    @Autowired
    private ExerciseDao exerciseDao;

    @Override
    public void updateGroup(String groupName, Exercise exercise) {
        MuscleGroup muscleGroup = muscleGroupDao.getByName(groupName);
        Set<Exercise> exercises = new HashSet<>(exerciseDao.exercisesByGroupId(muscleGroup.getId()));
        exercise.setMuscleGroup(muscleGroup);
        exercises.add(exercise);
        muscleGroupDao.saveOrUpdate(muscleGroup);
    }
}
