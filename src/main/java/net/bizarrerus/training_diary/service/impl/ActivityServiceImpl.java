package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.repository.interfaces.ActivityDao;
import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ActivityService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;
    @Autowired
    TrainingService trainingService;
    @Autowired
    ExerciseService exerciseService;

    @Override
    public void delete(Activity activity) {
        activityDao.delete(activity);
    }

    @Override
    public Activity get(int id) {
        return activityDao.get(id);
    }

    @Override
    public List getAll() {
        return activityDao.getAll();
    }

    @Override
    public void update(Activity activity) {
        activityDao.update(activity);
    }

    @Override
    public void save(Activity activity) {
        activityDao.save(activity);
    }

    @Override
    public void save(Activity activity, int exerciseID, int trainingID) {
        Training training = trainingService.get(trainingID);
        training.getActivities().add(activity);

        Exercise exercise = exerciseService.get(exerciseID);
        exercise.getActivities().add(activity);

        activity.setExercise(exercise);
        activity.setTraining(training);
        save(activity);
    }
}
