package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	private InstructorService instructorService;

	@Autowired
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("instructor_list");
		List<Instructor> instructorList = instructorService.getAllInstructors();

		model.addObject("instructorList", instructorList);

		return model;
	}

	@GetMapping("/addInstructor")
	public ModelAndView addInstructor() {
		ModelAndView model = new ModelAndView();

		Instructor instructor = new Instructor();

		model.addObject("instructorForm", instructor);
		model.setViewName("instructor_form");

		return model;
	}

	@GetMapping("/updateInstructor/{id}")
	public ModelAndView editInstructor(@PathVariable int id) {
		ModelAndView model = new ModelAndView();

		Instructor instructor = instructorService.getInstructorById(id);

		model.addObject("instructorForm", instructor);
		model.setViewName("instructor_form");

		return model;
	}

	@PostMapping("/saveInstructor")
	public ModelAndView save(@Valid @ModelAttribute("instructorForm") Instructor instructor,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return new ModelAndView("instructor_form");
		}

		instructorService.saveOrUpdate(instructor);

		return new ModelAndView("redirect:/instructor/list");

	}

	@GetMapping("/deleteInstructor/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		instructorService.deleteInstructor(id);

		return new ModelAndView("redirect:/instructor/list");
	}


	@GetMapping("/instructorInfo/{id}")
	public ModelAndView instructorInfo(@PathVariable("id") int id){

		ModelAndView model = new ModelAndView();

		Instructor instructor = instructorService.getInstructorById(id);
		List<Course> courseList = instructorService.getCoursesByInstructorID(id);
		model.addObject("courseList", courseList);
		model.addObject("instructor", instructor);
		model.setViewName("instructor_info");

		return model;
	}


}
