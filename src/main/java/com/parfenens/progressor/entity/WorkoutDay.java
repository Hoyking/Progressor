package com.parfenens.progressor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "days")
public class WorkoutDay {

    @Id
    @Column(name = "dayId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayId;

    @Column(name = "groupId", insertable = false, updatable = false)
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private WorkoutGroup group;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <WorkoutSet> sets;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private int type;

    /*public WorkoutDay() {
        sets = new ArrayList <WorkoutSet> ();
    }

    public WorkoutDay(List <WorkoutSet> sets, String date, int type) {
        this.sets = sets;
        this.setDate(date);
        this.type = type;
    }

    public void addSet(WorkoutSet set) {
        sets.add(set);
    }
    */
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

}
