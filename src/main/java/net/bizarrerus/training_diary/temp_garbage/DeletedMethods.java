package net.bizarrerus.training_diary.temp_garbage;

import java.time.LocalDate;
import java.util.List;

public class DeletedMethods {

    /**
     * method from TrainingService. that remove entity, without loses in datas
     * @param id
     */
    public void delete(int id) {
//        Training training = get(id);
//        for (Exercise exercise : training.getExercises()) {
//            exercise.getTrainings().remove(training);
//        }
//        training.getExercises().clear();
//        delete(training);
    }

    /**
     * TrainingServise save methods..
     * @param localDate
     * @param exercisesID
     */
    public void save(LocalDate localDate, List<Integer> exercisesID) {
//        Training training = new Training();
//        training.setTrainingDate(localDate);
//        training.setExercises(new HashSet<>());
//
//        Set<Exercise> exercises = new HashSet<>();
//        Exercise exercise;
//
//        for (Integer id : exercisesID) {
//            exercise = exerciseService.get(id);
//            exercise.getTrainings().add(training);
//            exercises.add(exercise);
//        }
//        training.getExercises().addAll(exercises);
//        save(training);
    }

//    @Override
//    public void save(LocalDate localDate) {
//        Training training = new Training();
//        training.setTrainingDate(localDate);
//        save(training);
//    }

//    @Override
//    public void save(LocalDate localDate, int complexID) {
//        Training training = new Training();
//        training.setTrainingDate(localDate);
//        training.setExercises(new HashSet<>());
//
//        Set<Exercise> exercises = complexService.get(complexID).getExercises();
//        for (Exercise exercise : exercises) {
//            exercise.getTrainings().add(training);
//        }
//        training.getExercises().addAll(exercises);
//        save(training);
//    }

//    @Override
//    public void save(LocalDate localDate, List<Integer> exercisesID) {
//        Training training = new Training();
//        training.setTrainingDate(localDate);
//        training.setExercises(new HashSet<>());
//
//        Set<Exercise> exercises = new HashSet<>();
//        Exercise exercise;
//
//        for (Integer id : exercisesID) {
//            exercise = exerciseService.get(id);
//            exercise.getTrainings().add(training);
//            exercises.add(exercise);
//        }
//        training.getExercises().addAll(exercises);
//        save(training);
//    }
}
