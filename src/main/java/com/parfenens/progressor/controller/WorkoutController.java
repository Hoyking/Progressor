package com.parfenens.progressor.controller;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.exception.EmptySetListException;
import com.parfenens.progressor.exception.EmptyWorkoutGroupNameException;
import com.parfenens.progressor.exception.ServerCrashException;
import com.parfenens.progressor.exception.WrongSetValueException;
import com.parfenens.progressor.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userProgress(Model model) {
        List<WorkoutGroup> groups = workoutService.getGroups();
        model.addAttribute("groups", groups);
        return "user_progress";
    }

    @RequestMapping(value = "/add_group", method = RequestMethod.POST)
    public @ResponseBody String addWorkout(@RequestParam("text") String text) {
        WorkoutGroup group = new WorkoutGroup();
        group.setName(text.trim());
        try {
            workoutService.addGroup(group);
        } catch (EmptyWorkoutGroupNameException e) {
            throw new ServerCrashException("The name of workout group should not be empty");
        }
        return "success";
    }

    @RequestMapping(value = "/add_day", method = RequestMethod.GET)
    public String addDayView(Model model, ServletRequest request) {
        long groupId = Long.parseLong(request.getParameter("group_id"));
        System.out.println(groupId);
        model.addAttribute("group_name", workoutService.getGroupByGroupId(groupId).getName());
        return "workout_day_add";
    }

    @RequestMapping(value = "/add_day", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String addDay(@RequestBody WorkoutDay day, ServletRequest request) {
        long groupId = Long.parseLong(request.getParameter("group_id"));
        day.setGroup(workoutService.getGroupByGroupId(groupId));
        day.getSets().forEach(set -> set.setDay(day));
        try {
            workoutService.addDay(day);
        } catch (WrongSetValueException | EmptySetListException e) {
            throw new ServerCrashException("Some set field has wrong value");
        }
        return "success";
    }

}
