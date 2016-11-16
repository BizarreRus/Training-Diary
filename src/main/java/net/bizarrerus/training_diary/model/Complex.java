package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "complexes")
public class Complex {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "complex_name")
    private String complex_name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "complex_exercise", joinColumns = @JoinColumn(name = "complex_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exercises;


    public Complex() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplex_name() {
        return complex_name;
    }

    public void setComplex_name(String complex_name) {
        this.complex_name = complex_name;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "id=" + id +
                ", complex_name='" + complex_name + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}
