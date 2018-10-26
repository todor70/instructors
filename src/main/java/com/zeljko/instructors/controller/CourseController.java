package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.service.CourseService;
import com.zeljko.instructors.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/course")
public class CourseController {

    public static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("course_list");
        List<Course> courseList = courseService.getAllCourses();

        model.addObject("courseList", courseList);

        return model;
    }

    @RequestMapping(value = "/addCourse/", method = RequestMethod.GET)
    public ModelAndView addCourse() {
        ModelAndView model = new ModelAndView();

        Course course = new Course();

        List<Instructor> instructorList = instructorService.getAllInstructors();
        model.addObject("instructorList", instructorList);

        model.addObject("courseAddForm", course);
        model.setViewName("course_add_form");

        return model;
    }

    @RequestMapping(value = "/editCourse/{id}", method = RequestMethod.GET)
    public ModelAndView editCourse(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Course course = courseService.getCourseById(id);

        List<Instructor> instructorList = instructorService.getAllInstructors();
        model.addObject("instructorList", instructorList);

        model.addObject("courseUpdateForm", course);
        model.setViewName("course_update_form");

        return model;
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
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

        if (courseService.isCourseExist(course)) {
            logger.error("Unable to create. A Course with title {} already exist", course.getTitle());
            ModelAndView model = new ModelAndView();
            model.addObject("course", course);
            model.setViewName("course_exists_error");
            return model;
        }
        courseService.saveOrUpdate(course);
        return new ModelAndView("redirect:/course/list");
    }

    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("courseUpdateForm") Course course) {

        courseService.saveOrUpdate(course);

        return new ModelAndView("redirect:/course/list");
    }

    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {

        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/list");
    }

}
