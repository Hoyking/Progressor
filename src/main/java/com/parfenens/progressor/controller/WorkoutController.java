package com.parfenens.progressor.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkoutController {
	
	private static final Logger log = Logger.getLogger(WorkoutController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String userProgress(Model model) {
		return "user_progress";
	}
	
	@RequestMapping(value = "/add_day", method = RequestMethod.GET)
	public String dayAdding(Model model) {
		return "workout_day_add";
	}
	
}
