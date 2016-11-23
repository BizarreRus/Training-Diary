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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "exercises")
    private Set<Complex> complexes;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private MuscleGroup muscleGroup;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private Set<Activity> activities;

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

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", complexes=" + complexes +
                ", muscleGroup=" + muscleGroup.getMuscleGroup() +
                ", activities=" + activities +
                '}';
    }
}
