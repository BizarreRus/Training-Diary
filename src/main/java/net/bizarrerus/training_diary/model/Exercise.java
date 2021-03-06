package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "exercise")
    private String exercise;

    @ManyToMany(mappedBy = "exercises", cascade = CascadeType.ALL)
    private Set<Complex> complexes;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private MuscleGroup muscleGroup;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private Set<Activity> activities;

    @ManyToMany(mappedBy = "exercises", cascade = CascadeType.ALL)
    private Set<Training> trainings;

    public Exercise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Set<Complex> getComplexes() {
        return complexes;
    }

    public void setComplexes(Set<Complex> complexes) {
        this.complexes = complexes;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public String toString() {
        return exercise;
    }
}
