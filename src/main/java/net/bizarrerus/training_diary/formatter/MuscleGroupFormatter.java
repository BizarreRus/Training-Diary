package net.bizarrerus.training_diary.formatter;

import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MuscleGroupFormatter implements Formatter<MuscleGroup> {
    @Autowired
    MuscleGroupService muscleGroupService;

    @Override
    public MuscleGroup parse(String groupId, Locale locale) throws ParseException {
        System.out.println("we are here now");
        MuscleGroup muscleGroup = muscleGroupService.get(Integer.parseInt(groupId));
        System.out.println("try to read it");
        if (muscleGroup != null) {
            System.out.println(muscleGroup.getMuscleGroup() + " and id " + muscleGroup.getId());
        }
        return muscleGroup;
    }

    @Override
    public String print(MuscleGroup muscleGroup, Locale locale) {
        return muscleGroup.getMuscleGroup();
    }
}
