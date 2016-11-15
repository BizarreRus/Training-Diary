package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.model.Exercise;

public interface MuscleGroupService {
    void updateGroup(Exercise exercise, String groupName);
}
