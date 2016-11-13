package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "exercise")
    private String exercise;

    @ManyToMany
    @JoinTable(name = "exercise_trainings", joinColumns = @JoinColumn(name = "exercise_id"),
    inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<Training> trainings;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private MuscleGroup muscleGroup;

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

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", trainings=" + trainings +
                ", muscleGroup=" + muscleGroup +
                '}';
    }
}
