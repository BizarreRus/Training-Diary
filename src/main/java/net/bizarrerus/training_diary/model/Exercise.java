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

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise_name='" + exercise + '\'' +
                ", complexes=" + complexes +
                ", muscleGroup=" + muscleGroup.getMuscleGroup() +
                '}';
    }
}
