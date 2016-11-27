package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.Training;

import java.util.List;

public interface TrainingDao {
    Training get(int id);

    void save(Training training);

    void saveOrUpdate(Training training);

    void update(Training training);

    void delete(Training training);

    List getAll();
}
