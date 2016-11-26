package net.bizarrerus.training_diary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "training_date")
    private Date training_date;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private Set<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "training_exercise", joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exercises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public Date getTrainingDate() {
        return training_date;
    }

    public void setTrainingDate(Date trainingDate) {
        this.training_date = trainingDate;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", date=" + training_date +
                ", activities=" + activities +
                ", user=" + user +
                ", exercises=" + exercises +
                '}';
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

}
