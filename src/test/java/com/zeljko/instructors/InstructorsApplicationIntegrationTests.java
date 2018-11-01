package com.zeljko.instructors;

import com.zeljko.instructors.repository.CourseRepository;
import com.zeljko.instructors.repository.InstructorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorsApplicationIntegrationTests {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void testFindAllInstructors() throws Exception {
		instructorRepository.findAll();
		instructorRepository.findAll(); // served from cache
	}

	@Test
	public void testFindAllCourses() throws Exception {
		courseRepository.findAll();
		courseRepository.findAll(); // served from cache
	}

	@Test
	public void testFindByTitle() throws Exception {
		courseRepository.findByTitle("java");
		courseRepository.findByTitle("java"); // served from cache
	}


}
