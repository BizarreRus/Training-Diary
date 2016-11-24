package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Training;

public interface TrainingService {

    Training get(int id);

    void save(Training training);

    void update(Training training);

    void delete(Training training);
}
