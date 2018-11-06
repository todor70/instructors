package com.zeljko.instructors.repository;

import com.zeljko.instructors.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findCourseById() {
        Optional<Course> course = courseRepository.findById(1);
        assertEquals("java", course.get().getTitle());
        assertEquals("2016-10-19", course.get().getStart().toString());
        assertEquals("2017-11-24", course.get().getEnd().toString());
        assertEquals("jovana", course.get().getInstructor().getFirstName());
    }

    @Test
    public void findCourseByTitle() throws Exception {
        Course course = courseRepository.findByTitle("spring");
        assertEquals("spring", course.getTitle());
        assertEquals("2017-07-09", course.getStart().toString());
        assertEquals("2018-09-01", course.getEnd().toString());
        assertEquals("petar", course.getInstructor().getFirstName());
    }

}
