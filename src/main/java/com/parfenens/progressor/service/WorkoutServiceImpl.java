package com.parfenens.progressor.service;

import com.parfenens.progressor.dao.WorkoutDAO;
import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;
import com.parfenens.progressor.exception.EmptySetListException;
import com.parfenens.progressor.exception.EmptyWorkoutGroupNameException;
import com.parfenens.progressor.exception.WrongSetValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	private WorkoutDAO workoutDAO;
	
	@Override
	@Transactional
	public void addGroup(WorkoutGroup group) throws EmptyWorkoutGroupNameException {
		if(group.getName().length() == 0)
		    throw new EmptyWorkoutGroupNameException("The name of workout group should not be empty");
		workoutDAO.addGroup(group);
	}

    @Override
    @Transactional
    public WorkoutGroup getGroupByGroupId(long id) {
        return workoutDAO.getGroupByGroupId(id);
    }

	@Override
	@Transactional
	public void addDay(WorkoutDay day) throws WrongSetValueException, EmptySetListException {
	    if(day.getSets().size() == 0) {
	        throw new EmptySetListException("Empty list of workout sets");
        }
        for (WorkoutSet set : day.getSets()) {
            if (set.getReps() == 0 || set.getWeight() == 0) {
                throw new WrongSetValueException("Some set field has wrong value");
            }
        }
        workoutDAO.addDay(day);
    }

	@Override
	@Transactional
	public List<WorkoutGroup> getGroups() {
	    return workoutDAO.getGroups();
	}

}
