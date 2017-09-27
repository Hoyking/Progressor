package com.parfenens.progressor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class WorkoutDay {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn
	@Column(name = "group")
	private WorkoutGroup group;
	
	@OneToMany(mappedBy = "day")
	private List <WorkoutSet> sets;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "type")
	private int type;
	
	/*public WorkoutDay() {
		sets = new ArrayList <WorkoutSet> ();
	}
	
	public WorkoutDay(List <WorkoutSet> sets, String date, int type) {
		this.sets = sets;
		this.setDate(date);
		this.type = type;
	}
	
	public void addSet(WorkoutSet set) {
		sets.add(set);
	}
	*/
	public List<WorkoutSet> getSets() {
		return sets;
	}

	public void setSets(List<WorkoutSet> sets) {
		this.sets = sets;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
