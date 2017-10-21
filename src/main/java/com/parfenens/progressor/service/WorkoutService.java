package com.parfenens.progressor.service;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.exception.EmptySetListException;
import com.parfenens.progressor.exception.EmptyWorkoutGroupNameException;
import com.parfenens.progressor.exception.WrongSetValueException;

import java.util.List;

public interface WorkoutService {

	void addGroup(WorkoutGroup group) throws EmptyWorkoutGroupNameException;

	WorkoutGroup getGroupByGroupId(long id);

	void addDay(WorkoutDay day) throws WrongSetValueException, EmptySetListException;
	
	List<WorkoutGroup> getGroups();
	
}
