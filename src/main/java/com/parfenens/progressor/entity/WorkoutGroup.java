package com.parfenens.progressor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class WorkoutGroup {

    @Id
    @Column(name = "groupId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <WorkoutDay> days;

    @Column(name = "name")
    private String name;

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

    public long getId() {
        return groupId;
    }

}
