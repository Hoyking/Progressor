package com.parfenens.progressor.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class WorkoutSet {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn
	@Column(name = "day")
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
