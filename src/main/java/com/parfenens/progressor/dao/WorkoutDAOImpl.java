package com.parfenens.progressor.dao;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addGroup(WorkoutGroup group) {
        getSession().save(group);
    }

    @Override
    public WorkoutGroup getGroupByGroupId(long id) {
        return (WorkoutGroup)getSession().get(WorkoutGroup.class, id);
    }

    @Override
    public void addDay(WorkoutDay day) {
        getSession().save(day);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<WorkoutGroup> getGroups() {
        Session session = getSession();
        return getSession().createQuery("from WorkoutGroup GROUP BY id").list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
