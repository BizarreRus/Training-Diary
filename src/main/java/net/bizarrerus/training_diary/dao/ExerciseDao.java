package net.bizarrerus.training_diary.dao;

import java.util.List;

public interface ExerciseDao {
    List exercisesByGroupId(int group_id);

    List exercises();
}
