package com.parfenens.progressor.dao;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;

import java.util.List;

public interface WorkoutDAO {

    void addGroup(WorkoutGroup group);

    WorkoutGroup getGroupByGroupId(long id);

    void addDay(WorkoutDay day);

    List<WorkoutGroup> getGroups();

}
