package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "muscle_groups")
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "group")
    private String group;

    @OneToMany(mappedBy = "muscleGroup", cascade = CascadeType.ALL)
    private Set<Exercise> exerciseSet;

    public MuscleGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Set<Exercise> getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(Set<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    @Override
    public String toString() {
        return "MuscleGroup{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", exerciseSet=" + exerciseSet +
                '}';
    }
}
