package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.repository.interfaces.TrainingDao;
import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.ComplexService;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingDao trainingDao;
    @Autowired
    private ComplexService complexService;
    @Autowired
    private ExerciseService exerciseService;

    @Override
    public Training get(int id) {
        return trainingDao.get(id);
    }

    @Override
    public void save(Training training) {
        trainingDao.save(training);
    }

    @Override
    public void save(Training training, List<Integer> exercisesID) {
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
    public void save(Training training, int complexID) {
        training.setExercises(new HashSet<>());

        Set<Exercise> exercises = complexService.get(complexID).getExercises();
        for (Exercise exercise : exercises) {
            exercise.getTrainings().add(training);
        }
        training.getExercises().addAll(exercises);
        save(training);
    }

    @Override
    public void update(Training training) {
        trainingDao.save(training);
    }

    @Override
    public void delete(int id) {
        trainingDao.delete(id);
    }

    @Override
    public List getAll() {
        return trainingDao.getAll();
    }
}