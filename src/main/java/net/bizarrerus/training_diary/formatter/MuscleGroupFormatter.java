package net.bizarrerus.training_diary.formatter;

import net.bizarrerus.training_diary.model.MuscleGroup;
import net.bizarrerus.training_diary.service.interfaces.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
// Should study more about Formatters and conversionServices for correctly usage in project
// For now not used
@Component
public class MuscleGroupFormatter implements Formatter<MuscleGroup> {
    @Autowired
    MuscleGroupService muscleGroupService;

    @Override
    public MuscleGroup parse(String groupId, Locale locale) throws ParseException {
        return muscleGroupService.get(Integer.parseInt(groupId));
    }

    @Override
    public String print(MuscleGroup muscleGroup, Locale locale) {
        return String.valueOf(muscleGroup.getId());
    }
}