package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.dao.MuscleGroupDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.MuscleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class MuscleGroupServiceImpl implements MuscleGroupService{
    @Autowired
    private MuscleGroupDao muscleGroupDao;

    @Override
    @Transactional
    public List getAll() {
        return muscleGroupDao.getAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(MuscleGroup muscleGroup) {
        muscleGroupDao.saveOrUpdate(muscleGroup);
    }

    @Override
    @Transactional
    public MuscleGroup getByName(String name) {
        return muscleGroupDao.getByName(name);
    }

    @Override
    @Transactional
    public MuscleGroup get(int id) {
        return muscleGroupDao.get(id);
    }

    @Override
    @Transactional
    public void delete(MuscleGroup muscleGroup) {
        muscleGroupDao.delete(muscleGroup);
    }

    @Override
    @Transactional
    public void updateGroup(Exercise exercise, String groupName) {
        MuscleGroup muscleGroup = getByName(groupName);
        exercise.setMuscleGroup(muscleGroup);
        muscleGroup.getExerciseSet().add(exercise);
        saveOrUpdate(muscleGroup);
    }

    @Override
    @Transactional
    public void deleteGroup(MuscleGroup muscleGroup) {
        MuscleGroup defaultGroup = getByName("Default");
        Set<Exercise> exercises = muscleGroup.getExerciseSet();
        for (Exercise exercise : exercises) {
            exercise.setMuscleGroup(defaultGroup);
        }
        defaultGroup.getExerciseSet().addAll(exercises);
        saveOrUpdate(defaultGroup);
        muscleGroup.getExerciseSet().clear();
        delete(muscleGroup);
    }

    @Override
    @Transactional
    public List getGroupNames() {
        List<String> names = new ArrayList<>();
        List<MuscleGroup> tmp = getAll();
        for (MuscleGroup muscleGroup : tmp) {
            if (!muscleGroup.getGroup_name().equals("Default")) {
                names.add(muscleGroup.getGroup_name());
            }
        }
        return names;
    }
}
