package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface CourseService {

    public List<Course> getAllCourses();

    public Course getCourseById(int Id);

    public void saveOrUpdate(Course course);

    public void deleteCourse(int Id);

    boolean isCourseExist(Course course);

}