package com.zeljko.instructors.repository;

import com.zeljko.instructors.entities.Instructor;
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
public class InstructorRepositoryTests {

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    public void findInstructorById() {
        Optional<Instructor> instructor = instructorRepository.findById(1);
        assertEquals("jovana", instructor.get().getFirstName());
        assertEquals("jovanovic", instructor.get().getLastName());
        assertEquals("kopernikova 11 nis", instructor.get().getAddress());
        assertEquals("064 1112444 ", instructor.get().getPhone());
        assertEquals("jovana@gmail.com", instructor.get().getEmail());
        assertEquals("1987-10-25", instructor.get().getDayOfBirth().toString());
    }

    @Test
    public void findCourseByInstructorId() throws Exception {
        Instructor instructor = instructorRepository.findCoursesByInstructorID(1);
        assertEquals("java", instructor.getCourses().get(0).getTitle());
        assertEquals("javaee", instructor.getCourses().get(1).getTitle());
        assertEquals("android", instructor.getCourses().get(2).getTitle());
    }
}
