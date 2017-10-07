package com.parfenens.progressor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sets")
public class WorkoutSet {

    @Id
    @Column(name = "setId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long setId;

    @ManyToOne
    @JoinColumn(name = "dayId")
    private WorkoutDay day;

    @Column(name = "weight")
    private double weight;

    @Column(name = "reps")
    private int reps;

	/*public WorkoutSet(double weight, int reps) {
		this.weight = weight;
		this.reps = reps;
	}*/

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

}
