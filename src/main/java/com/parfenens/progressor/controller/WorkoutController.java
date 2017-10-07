package com.parfenens.progressor.controller;

import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userProgress(Model model) {
        model.addAttribute("groups", workoutService.getGroups());
        return "user_progress";
    }

    @RequestMapping(value = "/add_group", method = RequestMethod.POST)
    public String workoutAdding(@RequestParam("text") String text) {
        WorkoutGroup group = new WorkoutGroup();
        group.setName(text);
        workoutService.addGroup(group);
        //System.out.println(text);
        return "redirect:/";
    }

    /*@RequestMapping(value = "/add_day", method = RequestMethod.GET)
    public String dayAdding(Model model) {
        return "workout_day_add";
    }*/

}
