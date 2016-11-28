package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Activity;

import java.util.List;

public interface ActivityService {

    void delete(Activity activity);

    Activity get(int id);

    List getAll();

    void update(Activity activity);

    void save(Activity activity);

    void save(Activity activity, int exerciseID, int trainingID);
}
