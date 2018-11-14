package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface CourseService {

     List<Course> getAllCourses();

     Course getCourseById(int Id);

     void saveOrUpdate(Course course);

     void deleteCourse(int Id);

    boolean isCourseExist(Course course);

}