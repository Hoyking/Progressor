package com.parfenens.progressor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "sets")
public class WorkoutSet {

    @Id
    @Column(name = "setId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long setId;

    @ManyToOne
    @JoinColumn(name = "dayId")
    @JsonIgnore
    private WorkoutDay day;

    @Column(name = "weight")
    private double weight;

    @Column(name = "reps")
    private int reps;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public WorkoutDay getDay() {
        return day;
    }

    public void setDay(WorkoutDay day) {
        this.day = day;
    }

}
