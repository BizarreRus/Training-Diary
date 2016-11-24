package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.Activity;

public interface ActivityDao {
    void delete(Activity activity);

    Activity get(int id);

    void update(Activity activity);

    void save(Activity activity);

}
