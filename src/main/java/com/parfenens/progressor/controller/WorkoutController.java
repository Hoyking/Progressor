package com.parfenens.progressor.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parfenens.progressor.entity.WorkoutDay;
import com.parfenens.progressor.entity.WorkoutGroup;
import com.parfenens.progressor.entity.WorkoutSet;

@Controller
public class WorkoutController {
	
	private static final Logger log = Logger.getLogger(WorkoutController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String userProgress(Model model) {
		/*WorkoutGroup group = new WorkoutGroup();
		group.setName("Подтягивания");
		
		WorkoutDay day1 = new WorkoutDay();
		day1.setDate("24 августа 2017 г.");
		day1.setType(2);
		for(int index = 0; index < 6; index++) {
			day1.addSet(new WorkoutSet(new Double(24.5), new Integer(7)));
		}
		
		WorkoutDay day2 = new WorkoutDay();
		day2.setDate("24 августа 2017 г.");
		day2.setType(2);
		for(int index = 0; index < 5; index++) {
			day2.addSet(new WorkoutSet(new Double(24.5), new Integer(7)));
		}
		
		WorkoutDay day3 = new WorkoutDay();
		day3.setDate("24 августа 2017 г.");
		day3.setType(1);
		for(int index = 0; index < 7; index++) {
			day3.addSet(new WorkoutSet(new Double(24.5), new Integer(7)));
		}
		
		WorkoutDay day4 = new WorkoutDay();
		day4.setDate("24 августа 2017 г.");
		day4.setType(0);
		for(int index = 0; index < 5; index++) {
			day4.addSet(new WorkoutSet(new Double(24.5), new Integer(7)));
		}
		
		group.setDays(Arrays.asList(day1, day2, day3, day4));
		
		List <WorkoutGroup> groups = Arrays.asList(group);
		
		
		
		model.addAttribute("groups", groups);*/
		return "user_progress";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void workoutAdding() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXMLGXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	@RequestMapping(value = "/add_day", method = RequestMethod.GET)
	public String dayAdding(Model model) {
		return "workout_day_add";
	}

}
