package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    public boolean isCourseExist(Course course) {
        return courseRepository.findByTitle(course.getTitle()) != null;
    }
}