package com.zeljko.instructors.repository;

import com.zeljko.instructors.entities.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    Instructor findCoursesByInstructorID(int id);


}