package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.Training;

import java.util.List;

public interface TrainingDao {
    Training get(int id);

    void save(Training training);

    void delete(int id);

    List getAll();
}
