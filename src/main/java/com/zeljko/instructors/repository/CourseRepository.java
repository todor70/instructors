package com.zeljko.instructors.repository;

import com.zeljko.instructors.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findByTitle(String title);

}