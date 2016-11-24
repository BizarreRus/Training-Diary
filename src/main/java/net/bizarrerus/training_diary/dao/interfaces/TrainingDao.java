package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.Training;

public interface TrainingDao {
    Training get(int id);

    void save(Training training);

    void update(Training training);

    void delete(Training training);
}
