package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Training;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    Training get(int id);

    void save(Training training);

    void update(Training training);

    void delete(Training training);

    void delete(int id);

    List getAll();
}
