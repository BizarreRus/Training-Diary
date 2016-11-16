package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.dao.ComplexDao;
import net.bizarrerus.training_diary.model.Complex;
import net.bizarrerus.training_diary.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ComplexServiceImpl implements ComplexService {
    @Autowired
    ComplexDao complexDao;
    @Autowired
    ExerciseService exerciseService;

    @Override
    @Transactional
    public void save(Complex complex, List<Integer> exercisesID) {
        Set<Exercise> exercises = new HashSet<>();
        for (Integer id : exercisesID) {
            exercises.add(exerciseService.get(id));
        }
        complex.setExercises(exercises);
        complexDao.save(complex);
    }

    @Override
    @Transactional
    public List getAll() {
        return complexDao.getAll();
    }
}
