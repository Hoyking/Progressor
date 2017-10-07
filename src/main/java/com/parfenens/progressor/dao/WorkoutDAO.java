package com.parfenens.progressor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;

public interface WorkoutDAO {

    public long addGroup(WorkoutGroup group);

    public long addDay(WorkoutDay day);

    public long addSet(WorkoutSet set);

    public List<WorkoutGroup> getGroups();

}