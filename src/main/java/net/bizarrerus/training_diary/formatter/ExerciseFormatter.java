package net.bizarrerus.training_diary.formatter;

import net.bizarrerus.training_diary.model.Exercise;
import net.bizarrerus.training_diary.service.interfaces.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
// Should study more about Formatters and conversionServices for correctly usage in project
// For now not used
@Component
public class ExerciseFormatter implements Formatter<Exercise> {
    @Autowired
    ExerciseService exerciseService;

    @Override
    public Exercise parse(String exerciseId, Locale locale) throws ParseException {
        return exerciseService.get(Integer.parseInt(exerciseId));
    }

    @Override
    public String print(Exercise exercise, Locale locale) {
        return String.valueOf(exercise.getId());
    }
}
