package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.TrainingDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    TrainingDao trainingDao;
    @Autowired
    ComplexService complexService;
    @Autowired
    ExerciseService exerciseService;

    @Override
    public Training get(int id) {
        return trainingDao.get(id);
    }

    @Override
    public void save(Training training) {
        trainingDao.saveOrUpdate(training);
    }

    @Override
    public void save(LocalDate localDate) {
        Training training = new Training();
        training.setTrainingDate(localDate);
        save(training);
    }

    @Override
    public void save(LocalDate localDate, int complexID) {
        Training training = new Training();
        training.setTrainingDate(localDate);
        training.setExercises(new HashSet<>());

        Set<Exercise> exercises = complexService.get(complexID).getExercises();
        for (Exercise exercise : exercises) {
            exercise.getTrainings().add(training);
        }
        training.getExercises().addAll(exercises);
        save(training);
    }

    @Override
    public void save(LocalDate localDate, List<Integer> exercisesID) {
        Training training = new Training();
        training.setTrainingDate(localDate);
        training.setExercises(new HashSet<>());

        Set<Exercise> exercises = new HashSet<>();
        Exercise exercise;

        for (Integer id : exercisesID) {
            exercise = exerciseService.get(id);
            exercise.getTrainings().add(training);
            exercises.add(exercise);
        }
        training.getExercises().addAll(exercises);
        save(training);
    }

    @Override
    public void update(Training training) {
        trainingDao.update(training);
    }

    @Override
    public void delete(Training training) {
        trainingDao.delete(training);
    }

    @Override
    public void delete(int id) {
        delete(get(id));
    }

    @Override
    public List getAll() {
        return trainingDao.getAll();
    }
}
