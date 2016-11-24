package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.TrainingDao;
import net.bizarrerus.training_diary.model.Training;
import net.bizarrerus.training_diary.service.interfaces.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService{
    @Autowired
    TrainingDao trainingDao;

    @Override
    public Training get(int id) {
        return trainingDao.get(id);
    }

    @Override
    public void save(Training training) {
        trainingDao.save(training);
    }

    @Override
    public void update(Training training) {
        trainingDao.update(training);
    }

    @Override
    public void delete(Training training) {
        trainingDao.delete(training);
    }
}
