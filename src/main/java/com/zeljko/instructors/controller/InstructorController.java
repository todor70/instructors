package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("instructor_list");
		List<Instructor> instructorList = instructorService.getAllInstructors();

		model.addObject("instructorList", instructorList);

		return model;
	}

	@RequestMapping(value = "/addInstructor/", method = RequestMethod.GET)
	public ModelAndView addInstructor() {
		ModelAndView model = new ModelAndView();

		Instructor instructor = new Instructor();

		model.addObject("instructorForm", instructor);
		model.setViewName("instructor_form");

		return model;
	}

	@RequestMapping(value = "/updateInstructor/{id}", method = RequestMethod.GET)
	public ModelAndView editInstructor(@PathVariable int id) {
		ModelAndView model = new ModelAndView();

		Instructor instructor = instructorService.getInstructorById(id);

		model.addObject("instructorForm", instructor);
		model.setViewName("instructor_form");

		return model;
	}

	@RequestMapping(value = "/saveInstructor", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("instructorForm") Instructor instructor,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return new ModelAndView("instructor_form");
		}

		instructorService.saveOrUpdate(instructor);

		return new ModelAndView("redirect:/instructor/list");

	}

	@RequestMapping(value = "/deleteInstructor/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {

		instructorService.deleteInstructor(id);

		return new ModelAndView("redirect:/instructor/list");
	}

}
