package com.parfenens.progressor.controller;

import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.exception.EmptyWorkoutGroupNameException;
import com.parfenens.progressor.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userProgress(Model model) {
        model.addAttribute("groups", workoutService.getGroups());
        System.out.println("main");
        return "user_progress";
    }

    @RequestMapping(value = "/add_group", method = RequestMethod.POST)
    public @ResponseBody String workoutAdding(@RequestParam("text") String text/*, HttpServletResponse response*/) {
        WorkoutGroup group = new WorkoutGroup();
        group.setName(text.trim());
        try {
            workoutService.addGroup(group);
        } catch (SQLIntegrityConstraintViolationException e) {
            //e.printStackTrace();
            System.out.println("exc 1");
        } /*catch (EmptyWorkoutGroupNameException e) {
            e.printStackTrace();
        }*/
        return "success";
    }

    /*@RequestMapping(value = "/add_day", method = RequestMethod.GET)
    public String dayAdding(Model model) {
        return "workout_day_add";
    }*/

}
