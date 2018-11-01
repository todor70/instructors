package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface InstructorService {

    public List<Instructor> getAllInstructors();

    public Instructor getInstructorById(int Id);

    public void saveOrUpdate(Instructor instructor);

    public void deleteInstructor(int Id);

    public List<Course> getCoursesByInstructorID(int Id);

}