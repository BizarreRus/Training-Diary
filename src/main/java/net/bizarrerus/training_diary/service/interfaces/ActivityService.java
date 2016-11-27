package net.bizarrerus.training_diary.service.interfaces;

import net.bizarrerus.training_diary.model.Activity;

public interface ActivityService {

    void delete(Activity activity);

    Activity get(int id);

    void update(Activity activity);

    void save(Activity activity);

    void save(Activity activity, int exerciseID, int trainingID);
}
