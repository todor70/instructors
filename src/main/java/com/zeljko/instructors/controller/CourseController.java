package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.service.CourseService;
import com.zeljko.instructors.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private CourseService courseService;
    private InstructorService instructorService;

    @Autowired
    public CourseController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("course_list");
        List<Course> courseList = courseService.getAllCourses();

        model.addObject("courseList", courseList);

        return model;
    }

    @GetMapping("/addCourse")
    public ModelAndView addCourse() {
        ModelAndView model = new ModelAndView("course_add_form");

        Course course = new Course();

        List<Instructor> instructorList = instructorService.getAllInstructors();
        model.addObject("instructorList", instructorList);

        model.addObject("courseAddForm", course);
        //model.setViewName("course_add_form");

        return model;
    }

    @GetMapping("/editCourse/{id}")
    public ModelAndView editCourse(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Course course = courseService.getCourseById(id);

        List<Instructor> instructorList = instructorService.getAllInstructors();

        instructorList.remove(course.getInstructor());

        instructorList.add(0, course.getInstructor());

        model.addObject("instructorList", instructorList);

        model.addObject("courseUpdateForm", course);
        model.setViewName("course_update_form");

        return model;
    }

    @PostMapping("/saveCourse")
    public ModelAndView save(@Valid @ModelAttribute("courseAddForm") Course course,
                             BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView();


            List<Instructor> instructorList = instructorService.getAllInstructors();
            model.addObject("instructorList", instructorList);

            model.addObject("courseAddForm", course);
            model.setViewName("course_add_form");

            return model;
        }

        logger.info("Creating Course : {}", course);

        if (courseService.isCourseExists(course)) {
            logger.error("Unable to create. A Course with title {} already exist", course.getTitle());
            ModelAndView model = new ModelAndView();
            model.addObject("course", course);
            model.setViewName("course_exists_error");
            return model;
        }
        courseService.saveOrUpdate(course);
        return new ModelAndView("redirect:/course/list");
    }

    @PostMapping("/updateCourse")
    public ModelAndView update(@ModelAttribute("courseUpdateForm") Course course) {

        courseService.saveOrUpdate(course);

        return new ModelAndView("redirect:/course/list");
    }

    @GetMapping("/deleteCourse/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {

        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/list");
    }

}
