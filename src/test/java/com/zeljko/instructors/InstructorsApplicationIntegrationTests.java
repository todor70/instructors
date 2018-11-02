package com.zeljko.instructors;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.repository.CourseRepository;
import com.zeljko.instructors.repository.InstructorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorsApplicationIntegrationTests {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void testFindInstructorById() {
		Optional<Instructor> instructor = instructorRepository.findById(1);
		assertEquals("jovana", instructor.get().getFirstName());
		assertEquals("jovanovic", instructor.get().getLastName());
		assertEquals("kopernikova 11 nis", instructor.get().getAddress());
		assertEquals("064 1112444 ", instructor.get().getPhone());
		assertEquals("jovana@gmail.com", instructor.get().getEmail());
		assertEquals("1987-10-25", instructor.get().getDayOfBirth().toString());
	}

	@Test
	public void testFindCourseById() {
		Optional<Course> course = courseRepository.findById(1);
		assertEquals("java", course.get().getTitle());
		assertEquals("2016-06-09", course.get().getStart().toString());
		assertEquals("2017-02-24", course.get().getEnd().toString());
		assertEquals("jovana", course.get().getInstructor().getFirstName());
	}

	@Test
	public void testFindCourseByTitle() throws Exception {
		Course course = courseRepository.findByTitle("spring");
		assertEquals("spring", course.getTitle());
		assertEquals("2017-07-09", course.getStart().toString());
		assertEquals("2018-09-01", course.getEnd().toString());
		assertEquals("petar", course.getInstructor().getFirstName());
	}

	@Test
	public void testFindCourseByInstructorId() throws Exception {
		Instructor instructor = instructorRepository.findCoursesByInstructorID(1);
		assertEquals("java", instructor.getCourses().get(0).getTitle());
		assertEquals("javaee", instructor.getCourses().get(1).getTitle());
		assertEquals("android", instructor.getCourses().get(2).getTitle());
	}



}
