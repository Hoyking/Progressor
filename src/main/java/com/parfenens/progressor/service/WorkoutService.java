package com.parfenens.progressor.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.parfenens.progressor.exception.EmptyWorkoutGroupNameException;
import org.springframework.stereotype.Service;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;

public interface WorkoutService {

	public long addGroup(WorkoutGroup group) throws SQLIntegrityConstraintViolationException;//, EmptyWorkoutGroupNameException;
	
	public long addDay(WorkoutDay day);
	
	public long addSet(WorkoutSet set);
	
	public List<WorkoutGroup> getGroups();
	
}
