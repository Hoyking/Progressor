package com.parfenens.progressor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.parfenens.progressor.dao.WorkoutDAO;
import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	private WorkoutDAO workoutDAO;
	
	@Override
	@Transactional
	public long addGroup(WorkoutGroup group) {
		return workoutDAO.addGroup(group);
	}

	@Override
	@Transactional
	public long addDay(WorkoutDay day) {
		workoutDAO.addDay(day);
		return 0;
	}

	@Override
	@Transactional
	public long addSet(WorkoutSet set) {
		workoutDAO.addSet(set);

		return 0;
	}

	@Override
	@Transactional
	public List<WorkoutGroup> getGroups() {
	    return workoutDAO.getGroups();
	}

}
