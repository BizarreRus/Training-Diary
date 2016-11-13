package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "training")
    private String training;

    @ManyToMany(mappedBy = "trainings")
    private Set<Exercise> exerciseSet;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    public Training() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public Set<Exercise> getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(Set<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", training='" + training + '\'' +
                ", exerciseSet=" + exerciseSet +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }
}
