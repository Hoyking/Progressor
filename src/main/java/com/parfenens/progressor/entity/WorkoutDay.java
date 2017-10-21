package com.parfenens.progressor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "days")
public class WorkoutDay {

    @Id
    @Column(name = "dayId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long dayId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    @JsonIgnore
    private WorkoutGroup group;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <WorkoutSet> sets;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private int type;

    public List<WorkoutSet> getSets() {
        return sets;
    }

    public void setSets(List<WorkoutSet> sets) {
        this.sets = sets;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WorkoutGroup getGroup() {
        return group;
    }

    public void setGroup(WorkoutGroup group) {
        this.group = group;
    }

}
