package com.parfenens.progressor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO {

   /* @Autowired
    ApplicationContext context;*/

    @Autowired
    private SessionFactory sessionFactory;// = (LocalSessionFactoryBean)context.getBean(LocalSessionFactoryBean.class);

    @Override
    public long addGroup(WorkoutGroup group) {
        sessionFactory.getCurrentSession().save(group);
        return group.getId();
    }

    @Override
    public long addDay(WorkoutDay day) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long addSet(WorkoutSet set) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<WorkoutGroup> getGroups() {
        return sessionFactory.getCurrentSession().createQuery("from WorkoutGroup ").list();
    }

}
