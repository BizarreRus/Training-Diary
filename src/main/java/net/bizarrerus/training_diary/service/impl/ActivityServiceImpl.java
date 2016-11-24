package net.bizarrerus.training_diary.service.impl;

import net.bizarrerus.training_diary.dao.interfaces.ActivityDao;
import net.bizarrerus.training_diary.model.Activity;
import net.bizarrerus.training_diary.service.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;

    @Override
    public void delete(Activity activity) {
        activityDao.delete(activity);
    }

    @Override
    public Activity get(int id) {
        return activityDao.get(id);
    }

    @Override
    public void update(Activity activity) {
        activityDao.update(activity);
    }

    @Override
    public void save(Activity activity) {
        activityDao.save(activity);
    }
}
