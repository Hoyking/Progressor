package com.parfenens.progressor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class WorkoutGroup {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "group")
	private List <WorkoutDay> days;
	
	@Column(name = "name")
	private String name;
	
	/*public WorkoutGroup() {
		days = new ArrayList<WorkoutDay>();
	}
	
	public WorkoutGroup(List <WorkoutDay> days, String name) {
		this.days = days;
		this.name = name;
	}

	public void addDay(WorkoutDay day) {
		days.add(day);
	}*/
	
	public List<WorkoutDay> getDays() {
		return days;
	}

	public void setDays(List<WorkoutDay> days) {
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
