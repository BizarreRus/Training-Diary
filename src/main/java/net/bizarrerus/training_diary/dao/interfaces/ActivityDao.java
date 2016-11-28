package net.bizarrerus.training_diary.dao.interfaces;

import net.bizarrerus.training_diary.model.Activity;

import java.util.List;

public interface ActivityDao {
    void delete(Activity activity);

    Activity get(int id);

    List getAll();

    void update(Activity activity);

    void save(Activity activity);

}
