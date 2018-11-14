package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface InstructorService {

     List<Instructor> getAllInstructors();

     Instructor getInstructorById(int Id);

     void saveOrUpdate(Instructor instructor);

     void deleteInstructor(int Id);

     List<Course> getCoursesByInstructorID(int Id);

}